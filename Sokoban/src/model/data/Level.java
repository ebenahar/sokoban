package model.data;

import java.io.Serializable;
import java.util.ArrayList;

import model.policy.Policy;

public class Level implements Serializable{

	private static final long serialVersionUID = 1L;

	private Policy policy;
	private int boxes;
	private int targets;
	private int boxesAndTargets;
	private Cell[][] matrix;
	private ArrayList<Player> players = new ArrayList<Player>();

	public Level(String level,Policy policy){
		this.boxesAndTargets = 0;
		this.policy = policy;
		this.level = level;
		int xMax = GetXmax(level);
		int yMax = GetYmax(level);
		matrix = new Cell[xMax][yMax];
		String [] levelRows = level.split("\n");
		for(int loop1=0;loop1<levelRows.length;loop1++)
		{
			for(int loop2=0;loop2<levelRows[loop1].length();loop2++)
			{
				matrix[loop2][loop1]=new Cell();
				switch(levelRows[loop1].charAt(loop2))
				{
				case '\n':
				case '\r':
					break;
				case ' ':
					matrix[loop2][loop1].cell.add(new Path(new Point(loop2,loop1)));
					matrix[loop2][loop1].setSymbol(' ');
					break;
				case '#':
					matrix[loop2][loop1].cell.add(new Wall(new Point(loop2,loop1)));
					matrix[loop2][loop1].setSymbol('#');
					break;

				case '@':
					matrix[loop2][loop1].cell.add(new Box(new Point(loop2,loop1)));
					matrix[loop2][loop1].setSymbol('@');

					boxes++;
					break;

				case 'o':
					matrix[loop2][loop1].cell.add(new Target(new Point(loop2,loop1)));
					matrix[loop2][loop1].setSymbol('o');
					targets++;
					break;

				case 'A':
					matrix[loop2][loop1].cell.add(new Player(new Point(loop2,loop1)));
					players.add(new Player(new Point(loop2,loop1)));
					matrix[loop2][loop1].setSymbol('A');
					break;

				case '$':
					matrix[loop2][loop1].cell.add((new Box(new Point(loop2,loop1))));
					matrix[loop2][loop1].cell.add(new Target(new Point(loop2,loop1)));
					matrix[loop2][loop1].setSymbol('$');
					boxes++;
					targets++;
					boxesAndTargets++;
					break;

				case '!':
					matrix[loop2][loop1].cell.add((new Player(new Point(loop2,loop1))));
					matrix[loop2][loop1].cell.add(new Target(new Point(loop2,loop1)));
					players.add(new Player(new Point(loop2,loop1)));
					matrix[loop2][loop1].setSymbol('!');
					targets++;
					break;
				default:

				}
			}
		}
		System.out.println(" num of boxes"+""+this.boxes);
		System.out.println("num of target"+""+this.targets);
		System.out.println("num of BoxNtarget"+""+this.boxesAndTargets);

	}
	
	public int getBoxesAndTargetsAmount(){
		return boxesAndTargets;
	}
	
	public void setBoxesAndTargetsAmount(int boxesAndTargets) {
		this.boxesAndTargets = boxesAndTargets;
	}

	private String level;
	public int steps;
	public int secondsCount;

	public Level(){
	}
	
	public Policy getPolicy(){
		return policy;
	}

	public void setPolicy(Policy policy){
		this.policy = policy;
	}

	public int getSteps(){
		return steps;
	}
	
	public void setSteps(int steps){
		this.steps = steps;
	}

	public int getSecondsCount(){
		return secondsCount;
	}
	
	public void setSecondsCount(int secondsCount){
		this.secondsCount = secondsCount;
	}

	public boolean levelValidate()
	{
		if(boxes!=targets)
			return false;
		return true;
	}

	public ArrayList<Player> getPlayers(){
		return players;
	}

	public void setPlayers(ArrayList<Player> players){
		this.players = players;
	}

	public void printToScreen(){

		System.out.println(level);
	}

	public Point nextPoint(Point dst, String direction)
	{
		switch(direction){
		case "right":
			return new Point(dst.getX()+1, dst.getY());
		case "left":
			return new Point(dst.getX()-1, dst.getY());
		case "up":
			return new Point(dst.getX(), dst.getY()-1);
		case"down":
			return new Point(dst.getX(), dst.getY()+1);
		}
		return null;
	}

	public char getSymbolByPoint(Point dest){
		return(matrix[dest.x][dest.y].getSymbol());
	}

	public int getPositionInArray(ArrayList<Obj> objs, char sym){

		for(int loop=0; loop<objs.size(); loop++){
			if(objs.get(loop).getSymbol() == sym)
				return loop;
		}
		return -1;

	}
	public int GetXmax(String string){
		int xMax=0;
		int count=0;
		for(int loop=0;loop<string.length();loop++)
		{
			if(string.charAt(loop)!='\n')
				count++;
			else
			{
				if(count>xMax)
				{
					xMax=count;
				}
				count=0;
			}
		}
		return xMax;

	}

	public int GetYmax(String string){
		int yMax=0;
		for(int loop=0;loop<string.length();loop++){
			if(string.charAt(loop)=='\n')
				yMax++;
		}
		return yMax;

	}

	public Cell[][] getMatrix(){
		return matrix;
	}

	public void setMatrix(Cell matrix[][]){
		this.matrix = matrix;
	}
	
	public int getBoxesAmount(){
		return boxes;
	}

	public void setBoxesAmount(int numOfBoxes){
		this.boxes = numOfBoxes;
	}

	public int getTargetsAmount(){
		return targets;
	}

	public void setTargetsAmount(int numOfTargets){
		this.targets = numOfTargets;
	}

	public String getLevel(){
		return level;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public void updateString(){
		String newString=new String();
		int x=0,y=0;
		for(int loop=0; loop<this.level.length(); loop++)
		{
			if(level.charAt(loop)!='\n')
				newString+=getSymbolByPoint(new Point(x++,y));
			else
			{
				newString+='\n';
				x=0;
				y++;
			}
		}
		this.level=newString;
	}
}
