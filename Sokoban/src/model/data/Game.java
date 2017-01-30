
package model.data;

public class Game extends Position{

	public Game(String direction,Level level){
		this.direction=direction;
		this.level = level;
	}

	public boolean getFinished(){
		return this.finished;
	}

	
	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level){
		this.level=level;
	}
	
	public boolean checkBoxAction(Point newDest){
		char updatedSym = level.getSymbolByPoint(newDest);
		if(updatedSym == '$' || updatedSym == '@' || updatedSym == '!' || updatedSym == 'A' || updatedSym == '#' )
			return level.getPolicy().pushBlockedBox();
		return true;
	}
	
	public boolean checkAction(Point src, Point dst, String direction){
		char dstSign = level.getSymbolByPoint(dst);
		if(dstSign == '#')
			return this.level.getPolicy().passThroughWall();

		if((dstSign == '@') || (dstSign == '$'))
		{
			switch(direction){
			case "right":
				return checkBoxAction(new Point(dst.getX()+1,dst.getY()));
			case "left":
				return checkBoxAction(new Point(dst.getX()-1,dst.getY()));
			case "up":
				return checkBoxAction(new Point(dst.getX(),dst.getY()-1));
			case "down":
				return checkBoxAction(new Point(dst.getX(),dst.getY()+1));
			}
		}
		if(dstSign == '!' || dstSign == 'A')
		{

			return false;
		}
		return true;
	}
		
	public void action(){

		boolean check;
		check = checkAction(this.getSrcPosition(), getDstPosition(), this.direction);
		if (check)
			moveItem(this.getSrcPosition(), this.direction, getDstPosition());
	}
	
	public boolean levelIsFinished(){

		if(level.getBoxesAmount() == this.boxesAndTargets)
			return true;
		return false;
	}

	public void moveItem(Point curPos, String direction,Point newPos){
		this.boxesAndTargets = this.level.getBoxesAndTargetsAmount();
		finished=true;
		int steps= level.getSteps();
		level.setSteps(++steps);

		Point updatedPos = this.level.nextPoint(newPos, direction);
		char cur = level.getSymbolByPoint(curPos);
		char newChar = level.getSymbolByPoint(newPos);
		int x = curPos.getX();
		int y = curPos.getY();
		int updatedX = newPos.getX();
		int updatedY = newPos.getY();
		int xNew = updatedPos.getX();
		int yNew = updatedPos.getY();


		switch(cur){
		case '!':
			this.level.getMatrix()[x][y].getCell().remove(level.getPositionInArray(level.getMatrix()[x][y].getCell(), 'A'));
			this.level.getMatrix()[x][y].getCell().add(new Path(new Point(x,y)));
			this.level.getMatrix()[x][y].setSymbol('o');
			this.level.getPlayers().get(0).setP(new Point(updatedX,updatedY));
			curPos.set(newPos);
			break;
		case 'A':
			this.level.getMatrix()[x][y].getCell().remove(level.getPositionInArray(level.getMatrix()[x][y].getCell(), 'A'));
			this.level.getMatrix()[x][y].getCell().add(new Path(new Point(x,y)));
			this.level.getMatrix()[x][y].setSymbol(' ');
			this.level.getPlayers().get(0).setP(new Point(updatedX,updatedY));
			curPos.set(newPos);

			break;
		}
		switch(newChar){
		case '$':
			this.level.getMatrix()[updatedX][updatedY].getCell().remove(level.getPositionInArray(level.getMatrix()[updatedX][updatedY].getCell(), '@'));
			this.level.getMatrix()[xNew][yNew].getCell().add(new Box(new Point(xNew,yNew)));
			this.level.getMatrix()[xNew][yNew].setSymbol('@');
			this.level.setBoxesAndTargetsAmount(--this.boxesAndTargets);
			System.out.println("NumBoxNtarget"+this.boxesAndTargets);


			this.level.getMatrix()[updatedX][updatedY].getCell().add(new Player(new Point(updatedX,updatedY)));
			this.level.getMatrix()[updatedX][updatedY].setSymbol('!');
			break;
		case '@':
			this.level.getMatrix()[updatedX][updatedY].getCell().remove(level.getPositionInArray(level.getMatrix()[updatedX][updatedY].getCell(), '@'));
			this.level.getMatrix()[xNew][yNew].getCell().add(new Box(new Point(xNew,yNew)));
			if(this.level.getMatrix()[xNew][yNew].getSymbol()=='o')
			{
				this.level.getMatrix()[xNew][yNew].setSymbol('$');
				this.level.setBoxesAndTargetsAmount(++this.boxesAndTargets);
				System.out.println("NumBoxNtarget"+this.boxesAndTargets);

			}
			else
				this.level.getMatrix()[xNew][yNew].setSymbol('@');
			this.level.getMatrix()[updatedX][updatedY].getCell().add(new Player(new Point(updatedX,updatedY)));
			this.level.getMatrix()[updatedX][updatedY].setSymbol('A');
			break;
			
		case ' ':
			this.level.getMatrix()[updatedX][updatedY].getCell().remove(level.getPositionInArray(level.getMatrix()[updatedX][updatedY].getCell(), ' '));
			this.level.getMatrix()[updatedX][updatedY].getCell().add(new Player(new Point(updatedX,updatedY)));
			this.level.getMatrix()[updatedX][updatedY].setSymbol('A');
			break;
			
		case 'o':
			this.level.getMatrix()[updatedX][updatedY].getCell().add(new Player(new Point(updatedX,updatedY)));
			this.level.getMatrix()[updatedX][updatedY].setSymbol('!');
			break;
		
		}
		this.level.updateString();
	}
}