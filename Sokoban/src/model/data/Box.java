
package model.data;

import java.io.Serializable;


public class Box extends Obj implements Serializable{

	private static final long serialVersionUID = 1L;

	public Box(){
	}
	
	public Box(Point p) {
		this.p=p;
	}

	@Override
	public char getSymbol() {
		return '@';
	}
}


