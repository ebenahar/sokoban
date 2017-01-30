package controller.commands;

import model.Model;
import view.View;

public class Exit extends Command{

	Model model;
	View view;

	public Exit(View view, Model model){
		this.view=view;
		this.model=model;
	}

	@Override
	public void execute() {
		this.model.exit();
	}
}