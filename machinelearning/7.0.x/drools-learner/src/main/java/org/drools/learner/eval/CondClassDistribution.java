package org.drools.learner.eval;

import java.util.Hashtable;

import org.drools.learner.Domain;
import org.drools.learner.tools.Util;

public class CondClassDistribution {
	
	private String sumKey = Util.sum();
	
	private Domain condAttr; // domain of the attr we distribute the instances conditionally
	private Hashtable<Object, ClassDistribution> condQuantityByClass;
	
	private double totalNum;
	
	public CondClassDistribution(Domain attributeDomain, Domain targetDomain) {
		this.condAttr = attributeDomain;
		//List<?> attributeValues = this.domain.getValues();
		condQuantityByClass = new Hashtable<Object, ClassDistribution>(attributeDomain.getCategoryCount());
		
		for (int c_idx = 0; c_idx<attributeDomain.getCategoryCount(); c_idx++) {
			Object attr_category = attributeDomain.getCategory(c_idx);
			condQuantityByClass.put(attr_category, new ClassDistribution(targetDomain));
		}
		
	}
	
	public CondClassDistribution(CondClassDistribution copy) {
		this.condAttr = copy.getAttrDomain();
		this.condQuantityByClass = new Hashtable<Object, ClassDistribution>(copy.getNumCondClasses());
		
		for (int cIdx = 0; cIdx< this.condAttr.getCategoryCount(); cIdx++) {
			Object attrCategory = this.condAttr.getCategory(cIdx);
			this.condQuantityByClass.put(attrCategory, new ClassDistribution(copy.getDistributionOf(attrCategory)));
		}
		this.totalNum = copy.getTotal();
		
	}
	
	public double getTotal() {
		return this.totalNum;	
	}
	
	public void setTotal(double size) {
		this.totalNum = size;	
	}
	
	public Domain getAttrDomain() {
		return condAttr;
	}
//	public String getTargetName() {
//		return target_attr.getFName();
//	}
	
	public Object getCondClass(int idx) {
		return condAttr.getCategory(idx);
	}
	
	public int getNumCondClasses() {
		return condAttr.getCategoryCount();
	}
	
	public double getTotalAttrCategory(Object attrValue) {
		return condQuantityByClass.get(attrValue).getSum();
	}
	
	public void change(Object attrCategory, Object target_class, double i) {
//		System.out.print("The cond_dist: a_cat:"+ attr_category+" t_cat:"+ target_class);
//		System.out.println(" the nums: "+cond_quantity_by_class.get(attr_category));
		
		condQuantityByClass.get(attrCategory).change(target_class, i);		
		condQuantityByClass.get(attrCategory).change(sumKey, i);
		
	}
	
	public ClassDistribution getDistributionOf(Object attrValue) {
		return condQuantityByClass.get(attrValue);
	}
	public void clear() {
		this.condQuantityByClass.clear();
		// all for each?
	}
	
	public void setDistForAttrValue(Object attrValue, ClassDistribution factsInClass) {
		//cond_quantity_by_class.put(attr_value, targetDist);
		/* TODO should i make a clone */	
		condQuantityByClass.get(attrValue).setDistribution(factsInClass);
		
	}
	public String toString() {
		StringBuffer sbOut = new StringBuffer("\nCondClassDist: attr: "+condAttr.getFName()+" total num: "+ this.getTotal() + "\n") ;
		for (int cIdx = 0; cIdx<condAttr.getCategoryCount(); cIdx++) {
			Object attrCategory = condAttr.getCategory(cIdx);
			ClassDistribution td = condQuantityByClass.get(attrCategory);
			sbOut.append("(ATTR:"+attrCategory+ "=> "+ td +")");
		}
		return sbOut.toString();
	}	

}