package org.drools.learner.eval;


import java.util.ArrayList;
import java.util.List;

import org.drools.learner.Domain;
import org.drools.learner.Instance;
import org.drools.learner.QuantitativeDomain;
import org.drools.learner.tools.LoggerFactory;
import org.drools.learner.tools.SimpleLogger;
import org.drools.learner.tools.Util;

public class Entropy implements Heuristic{
	
	private static SimpleLogger flog = LoggerFactory.getUniqueFileLogger(Entropy.class, SimpleLogger.DEFAULT_LEVEL);
	//public Entropy
	/* 
	 * - chooses the best attribute,
	 * - return the choosen attributes evaluation results (information gain and/or gain ratio)
	 * can process categorical, and quantitative attribute domains
	 * 
	 * used by:
	 * c45Alternator, c45Learner, c45Iterator
	 */
	
	protected static double multiplier = 1.0;
	protected double dataEval; 
	protected InstDistribution instsByTarget;
	protected ArrayList<Instance> sortedInstances;
	protected Domain domain;

	public Entropy() {
		//
	}
	
	public void init(InstDistribution instsByTarget) {
		this.instsByTarget = instsByTarget;
		dataEval = calcInfo(instsByTarget);
		sortedInstances = null;
		domain = null;
	}
	
	
	public double getEval(Domain attrDomain) {
		CondClassDistribution instsByAttr = infoAttr(attrDomain);	
		return multiplier *(dataEval - Entropy.calcInfoAttr(instsByAttr));
	}
	
	public double getEvalCont(Domain attrDomain) {
		
		double attributeEval= 0.0d;
		QuantitativeDomain trialDomain = QuantitativeDomain.createFromDomain(attrDomain);

		Categorizer visitor = new Categorizer(instsByTarget);
		visitor.findSplits(trialDomain);

		//	trial domain is modified				
		if (trialDomain.getNumIndices() > 1) {
			CondClassDistribution instsByAttr = infoContattr(visitor); //.getSortedInstances(), trialDomain);
			attributeEval = dataEval - Entropy.calcInfoAttr(instsByAttr);
		}
		domain = trialDomain;
		sortedInstances = visitor.getSortedInstances();
		return multiplier *attributeEval;
	}
	
	public double getDataEval() {
		return dataEval;
	}
	
	public Domain getDomain() {
		return domain;
	}
	
	public ArrayList<Instance> getSortedInstances() {
		return sortedInstances;
	}

	public double getWorstEval() {
		return multiplier -1000;
	}
	
	public CondClassDistribution infoAttr(Domain attrDomain) {
		
		Domain targetDomain = instsByTarget.getClassDomain();
		
		//flog.debug("What is the attributeToSplit? " + attr_domain);

		/* initialize the hashtable */
		CondClassDistribution instsByAttr = new CondClassDistribution(attrDomain, targetDomain);
		instsByAttr.setTotal(instsByTarget.getSum());
		
		//flog.debug("Cond distribution for "+ attr_domain + " \n"+ insts_by_attr);
		
		for (int category = 0; category<targetDomain.getCategoryCount(); category++) {
			Object targetCategory = targetDomain.getCategory(category); 
			
			for (Instance inst: instsByTarget.getSupportersFor(targetCategory)) {
				Object instAttrCategory = inst.getAttrValue(attrDomain.getFReferenceName());
				
				Object instClass = inst.getAttrValue(targetDomain.getFReferenceName());
				
				if (!targetCategory.equals(instClass)) {
					if (flog.error() != null)
						flog.error().log("How the fuck they are not the same ? "+ targetCategory + " " + instClass);
					System.exit(0);
				}
				instsByAttr.change(instAttrCategory, targetCategory, inst.getWeight()); //+1
				
			}
		}
		
		return instsByAttr;
	}
	
	
	/* calculates the information of a quantitative domain given the split indexes of instances 
	 * a wrapper for the quantitative domain to be able to calculate the stats
	 * */
	//public static double info_contattr(InstanceList data, Domain targetDomain, QuantitativeDomain splitDomain) {
	public CondClassDistribution infoContattr(Categorizer visitor) {
		
		List<Instance> data = visitor.getSortedInstances();
		QuantitativeDomain splitDomain = visitor.getSplitDomain();
		Domain targetDomain = instsByTarget.getClassDomain();
		String targetAttr = targetDomain.getFReferenceName();
		
		CondClassDistribution instancesByAttr = new CondClassDistribution(splitDomain, targetDomain);
		instancesByAttr.setTotal(data.size());
		
		int index = 0;
		int splitIndex = 0;
		Object attrKey = splitDomain.getCategory(splitIndex);
		for (Instance i : data) {
			
			if (index == splitDomain.getSplit(splitIndex).getIndex()+1 ) {
				attrKey = splitDomain.getCategory(splitIndex+1);
				splitIndex++;	
			}
			Object targetKey = i.getAttrValue(targetAttr);
			instancesByAttr.change(attrKey, targetKey, i.getWeight());	//+1
			
			index++;
		}
		
		return instancesByAttr;
//		double sum = calc_info_attr(instances_by_attr);
//		return sum;
		
	}
	
	/*
	 * for both 
	 */
	public static double calcInfoAttr( CondClassDistribution instancesByAttr) {
		//Collection<Object> attributeValues = instances_by_attr.getAttributes();
		double dataSize = instancesByAttr.getTotal();
		double sum = 0.0;
		if (dataSize>0)
			for (int attrIdx=0; attrIdx<instancesByAttr.getNumCondClasses(); attrIdx++) {
				Object attrCategory = instancesByAttr.getCondClass(attrIdx);
				double totalNumAttr = instancesByAttr.getTotalAttrCategory(attrCategory);

				if (totalNumAttr > 0) {
					double prob = totalNumAttr / dataSize;
					//flog.debug("{("+total_num_attr +"/"+data_size +":"+prob +")* [");
					double info =  calcInfo(instancesByAttr.getDistributionOf(attrCategory));

					sum += prob * info;
					//flog.debug("]} ");
				}
			}
		//flog.debug("\n == "+sum);
		return sum;
	}
	
	/* you can calculate this before */
	/**
	 * it returns the information value of facts entropy that characterizes the
	 * (im)purity of an arbitrary collection of examples
	 * 
	 * @param quantityByClass the distribution of the instances by the class attribute (target)
	 */
	public static double calcInfo(ClassDistribution quantityByClass) {
		
		double dataSize = quantityByClass.getSum();
		
		double prob, sum = 0;
		Domain targetDomain = quantityByClass.getClassDomain();
		if (dataSize > 0)
		for (int category = 0; category<targetDomain.getCategoryCount(); category++) {
			
			Object targetCategory = targetDomain.getCategory(category);
			double numInClass = quantityByClass.getVoteFor(targetCategory);

			if (numInClass > 0) {
				prob = numInClass / dataSize;
				/* TODO what if it is a sooo small number ???? */
				//flog.debug("("+num_in_class+ "/"+data_size+":"+prob+")" +"*"+ Util.log2(prob) + " + ");
				sum -=  prob * Util.log2(prob);
			}
		}
		//flog.debug("= " +sum);
		return sum;
	}
}
