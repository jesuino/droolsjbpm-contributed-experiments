package org.drools.learner.eval;

public class SplitPoint {
	
	private int index;
	private Object cutPoint;
	private double infoValue;
	
	public SplitPoint(int _index, Object point) {
		this.index = _index;
		this.cutPoint = point;
	}
	
	public Object getValue() {
		return cutPoint;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setInformationValue(double infoSum) {
		this.infoValue = infoSum;
	}

}
