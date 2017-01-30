package model.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Cell implements Serializable{

	private static final long serialVersionUID = 1L;


	public ArrayList<Obj> cell;
	public char symbol;


	public Cell() {
		this.cell = new ArrayList<Obj>();

	}

	public ArrayList<Obj> getCell() {
		return cell;
	}

	public void setCell(ArrayList<Obj> cell) {
		this.cell = cell;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getPositionInArray(ArrayList<Obj> cell,char symbol) {
		for(int i=0;i<cell.size();i++)
		{
			if(cell.get(i).getSymbol()==symbol)
				return i;
		}
		return -1;

	}


}