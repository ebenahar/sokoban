
package model.data;


public abstract class Obj implements ObjInterface {

	protected Point p;


	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public abstract char getSymbol();



}