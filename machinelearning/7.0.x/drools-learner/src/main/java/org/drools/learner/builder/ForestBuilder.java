package org.drools.learner.builder;

import java.util.ArrayList;

import org.drools.learner.DecisionTree;
import org.drools.learner.InstanceList;
import org.drools.learner.Memory;
import org.drools.learner.Stats;
import org.drools.learner.StatsPrinter;
import org.drools.learner.builder.BoostedTester;
import org.drools.learner.builder.ForestTester;
import org.drools.learner.builder.SingleTreeTester;
import org.drools.learner.builder.Tester;
import org.drools.learner.tools.LoggerFactory;
import org.drools.learner.tools.SimpleLogger;
import org.drools.learner.tools.Util;

public class ForestBuilder extends DecisionTreeBuilder{

	private static SimpleLogger flog = LoggerFactory.getUniqueFileLogger(ForestBuilder.class, SimpleLogger.DEFAULT_LEVEL);
	private static SimpleLogger slog = LoggerFactory.getSysOutLogger(ForestBuilder.class, SimpleLogger.DEFAULT_LEVEL);
	
	private TreeAlgo algorithm = TreeAlgo.BAG; // default bagging, TODO boosting
	
//	private double trainRatio = Util.TRAINING_RATIO, testRatio = Util.TESTING_RATIO;
	
	private static final int FOREST_SIZE = Util.NUM_TREES;
	private static final double TREE_SIZE_RATIO = 0.9;
	private static final boolean WITH_REP = true;
	
	private ArrayList<DecisionTree> forest;
	//private Learner trainer;

	
	private DecisionTreeMerger merger;
//	private ForestTester tester;
//	private SingleTreeTester single_tester;
	
//	private ArrayList<Stats> train_evaluation, test_evaluation;
	
	public ForestBuilder() {
		//this.trainer = _trainer;
		merger = new DecisionTreeMerger();
//		train_evaluation = new ArrayList<Stats>(FOREST_SIZE);
//		test_evaluation = new ArrayList<Stats>(FOREST_SIZE);
	}
	
	public void internalBuild(SolutionSet solSet, Learner trainer) {
		trainer.setInputSpec(solSet.getInputSpec());
		if (solSet.getTargets().size()>1) {
			//throw new FeatureNotSupported("There is more than 1 target candidates");
			if (flog.error() !=null)
				flog.error().log("There is more than 1 target candidates");
			
			System.exit(0);
			// TODO put the feature not supported exception || implement it
		} else if (trainer.getTargetDomain().getCategoryCount() >2) {
			if (slog.error() !=null)
				slog.error().log("The target domain is not binary!!!\n");
			System.exit(0);
		}
		
		
		int N = solSet.getTrainSet().getSize();
		int treeCapacity = (int)(TREE_SIZE_RATIO * N);
		trainer.setTrainingDataSizePerTree(treeCapacity);
		/* tree_capacity number of data fed to each tree, there are FOREST_SIZE trees*/
		trainer.setTrainingDataSize(treeCapacity * FOREST_SIZE);

		
		forest = new ArrayList<DecisionTree> (FOREST_SIZE);
		int i = 0;
		int[] bag;		
		while (i++ < FOREST_SIZE) {
			if (WITH_REP)
				bag = Util.bagWRep(treeCapacity, N);
			else
				bag = Util.bagWoRep(treeCapacity, N);
			
			//InstanceList working_instances = class_instances.getInstances(bag);	
			InstanceList workingInstances = solSet.getTrainSet().getInstances(bag);	
			
			DecisionTree dt = trainer.instantiateTree();
			if (slog.debug() != null)
				slog.debug().log("\n"+"Training a tree"+"\n");
			trainer.trainTree(dt, workingInstances);
			if (slog.debug() != null)
				slog.debug().log("\n"+"the end"+ "\n");
			dt.setID(i);
			forest.add(dt);
			// the DecisionTreeMerger will visit the decision tree and add the paths that have not been seen yet to the list
			merger.add(dt);	
			

			if (slog.stat() !=null)
				slog.stat().stat(".");
//			SingleTreeTester single_tester = new SingleTreeTester(dt);
//			train_evaluation.add(single_tester.test(sol_set.getTrainSet()));
//			test_evaluation.add(single_tester.test(sol_set.getTestSet()));
			
			// adding to the set of solutions
			Tester t = getTester(dt);
			Stats train = t.test(workingInstances);
			Stats test = t.test(solSet.getTestSet());
			Solution one = new Solution(dt, workingInstances);
			one.setTestList(solSet.getTestSet());
			one.setTrainStats(train);
			one.setTestStats(test);
			solSet.addSolution(one);

		}
		
//		tester = new ForestTester(forest);
//		train_evaluation.add(tester.test(sol_set.getTrainSet()));
//		test_evaluation.add(tester.test(sol_set.getTestSet()));
		
		Tester globalTester = getTester(forest);
		Stats train = globalTester.test(solSet.getTrainSet());
		Stats test = globalTester.test(solSet.getTestSet());
		solSet.setGlobalTrainStats(train);
		solSet.setGlobalTestStats(test);
		
		//System.exit(0);
		// TODO how to compute a best tree from the forest
		int bestId = solSet.getMinTestId();
		solSet.setBestSolutionId(bestId);
		
		
		
		return;
		
	}
	
	
	public Tester getTester(ArrayList<DecisionTree> forest) {
		return new ForestTester(forest); 
	}
	

	public TreeAlgo getTreeAlgo() {
		return algorithm; //TreeAlgo.BAG; // default
	}
	
	public ArrayList<DecisionTree> getTrees() {
		return forest;
	}
	
	public Solution getBestSolution() {
		return solutions.getBestSolution();
	}

}


