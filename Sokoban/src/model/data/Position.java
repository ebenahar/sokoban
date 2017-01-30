package model.data;

public class Position {
	
	
	int boxesAndTargets;
	public String direction;
	public Level level;
	boolean finished = false;
	
	public Point getSrcPosition(){
		return level.getPlayers().get(0).getP();
	}

	public String getDirection(){
		return this.direction;
	}

	public void setDirection(String direction){
		this.direction=direction;
	}
	
	public Point getDstPosition(){
		Point dstPos;
		int x;
		int y;
		switch (this.direction){
		case "right":

			x=this.getSrcPosition().getX();
			x++;
			dstPos= new Point(x,this.getSrcPosition().getY());
			return dstPos;

		case "left":
			x=this.getSrcPosition().getX();
			x--;
			dstPos= new Point(x,this.getSrcPosition().getY());
			return dstPos;
		case "up":
			y=this.getSrcPosition().getY();
			y--;
			dstPos= new Point(getSrcPosition().getX(),y);
			return dstPos;

		case "down":
			y=this.getSrcPosition().getY();
			y++;
			dstPos= new Point(getSrcPosition().getX(),y);
			return dstPos;		
		}
		return null;
	}
}
