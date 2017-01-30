package controller.commands;

import model.Model;


public class LoadLevelCommand extends Command{

	private String string;
	private Model model;

	public LoadLevelCommand(Model ml){
		this.model=ml;
	}

	public String getType(){
		return string;
	}

	public void setType(String type){
		this.string = type;
	}

	@Override
	public void execute(){
		this.model.load(this.params.get(0));
	}
}
