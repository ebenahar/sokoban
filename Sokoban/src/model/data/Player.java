package model.data;


import java.io.Serializable;


public class Player extends Obj implements Serializable{

	private static final long serialVersionUID = 1L;

	public Player(){
	}

	public Player(Point p) {
			this.p=p;
	}

	@Override
	public char getSymbol() {
		return 'A';
	}
}