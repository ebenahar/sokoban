package model.data;

import java.io.Serializable;


public class Target extends Obj implements Serializable{

	private static final long serialVersionUID = 1L;

	public Target() {
	}
	
	public Target(Point p){
		this.p=p;
	}

	int targetsAmount;

	public int getNumOfTargets(){
		return targetsAmount;
	}

	public void setNumOfTargets(int numOfTargets){
		this.targetsAmount = numOfTargets;
	}

	@Override
	public char getSymbol(){
		return 'o';
	}
}