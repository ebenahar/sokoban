package controller.commands;

import model.Model;
import model.data.Level;
import view.View;

public class DisplayLevelCommand extends Command{
	Model model;
	View view;
	Level level;

	public DisplayLevelCommand(View vw, Model ml){
		this.model=ml;
		this.view=vw;
	}
	
	@Override
	public void execute(){

		this.level=model.getLevel();

		if (params != null){
			if(params.size()==1){
				view.moveMade();
				view.display(level);
			}
			if(params.size()==2){
				view.moveMade();
				view.display(level);
				view.levelFinshed();
			}
		}
		view.display(this.level);
	}
}