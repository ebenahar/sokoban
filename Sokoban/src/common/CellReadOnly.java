package common;
import java.io.Serializable;

import model.data.Cell;
import model.data.Obj;

public class CellReadOnly implements Serializable{

	private static final long serialVersionUID = 1L;

	public CellReadOnly() {
	}
	private Obj[] array;
	private char symbol;

	public CellReadOnly(Cell myCell) {

		array=myCell.getCell().toArray(new Obj[myCell.getCell().size()]);
		symbol=myCell.getSymbol();
	}

	public Obj[] getArray() {
		return array;
	}

	public void setArray(Obj[] array) {
		this.array = array;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}


}