package controller.commands;

import model.Model;


public class MoveCommand extends Command{

	private Model model;
	private String direction;

	public MoveCommand(Model model){
		this.model = model;
	}
	
	public void setDirection(String direction){
		this.direction = direction;
	}
	
	public String getDirection(){
		return direction;
	}
	
	public void execute(){
		this.direction = params.get(0);
		this.model.move(direction);
	}
}