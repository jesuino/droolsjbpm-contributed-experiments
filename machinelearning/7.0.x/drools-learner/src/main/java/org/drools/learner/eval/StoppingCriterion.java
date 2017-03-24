package org.drools.learner.eval;

import org.drools.learner.DecisionTree;

public interface StoppingCriterion {
	
	public boolean stop(InformationContainer bestAttrEval);

}
