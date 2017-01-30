package model.data;


import java.io.Serializable;


public class Path extends Obj implements Serializable{

	private static final long serialVersionUID = 1L;

	public Path(){
	}
	
	public Path(Point p){
		this.p=p;
	}

	@Override
	public char getSymbol() {

		return ' ';
	}


}