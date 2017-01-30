package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import controller.commands.Command;
import controller.commands.DisplayLevelCommand;
import controller.commands.Exit;
import controller.commands.LoadLevelCommand;
import controller.commands.MoveCommand;
import controller.commands.Save;
import model.Model;
import view.View;



public class SokobanController implements Observer{

	Model model;
	View view;
	private Controller controller;
	private HashMap<String, Command> commands;


	public void start(){

	}

	public SokobanController(Model ml, View vw){
		this.model=ml;
		this.view=vw;
		
		controller= new Controller();
		controller.start();

		initCommands();
	}

	public void initCommands(){
		commands = new HashMap<String, Command>();
		commands.put("Load", new LoadLevelCommand(model));
		commands.put("Display", new DisplayLevelCommand(view,model));
		commands.put("Move", new MoveCommand(model));
		commands.put("Save", new Save(model));
		commands.put("Exit", new Exit(view,model));
	}

	@Override
	public void update(Observable observable, Object arg){
		LinkedList<String> params = (LinkedList<String>) arg;
		for (String string : params){
		}
		String commandKey = params.remove(0);
		Command cmd = commands.get(commandKey);
		if (cmd == null){
			view.displayMessage("Not found");
			return;
		}
		else if(commandKey=="Exit")
			controller.stop();

		cmd.setParams(params);
		controller.insertCommand(cmd);

	}

}

