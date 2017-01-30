package model.data;

import java.io.Serializable;


public class Wall extends Obj implements Serializable {

	private static final long serialVersionUID = 1L;

	public Wall(){
	}	

	public Wall(Point p){
		this.p=p;
	}

	@Override
	public char getSymbol(){
		return '#';
	}
}