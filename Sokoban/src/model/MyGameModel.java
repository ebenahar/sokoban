package model;

import java.util.LinkedList;
import java.util.Observable;

import controller.commands.ExitListener;
import model.data.Game;
import model.data.Level;


public class MyGameModel extends Observable implements Model {

	private Level level;
	private LoadFile loader;
	private Game mover;
	private SaveFile saver;

	@Override
	public Level getLevel() {
		return this.level;
	}

	@Override
	public void move(String direction) {
		mover=new Game(direction,this.level);
		mover.action();
		this.level=mover.getLevel();
		LinkedList<String> params= new LinkedList<String>();
		params.add("DISPLAY");
		if(mover.getFinished())
			params.add("done");

		if(mover.levelIsFinished())
			params.add("finish");

		setChanged();
		notifyObservers(params);



	}

	@Override
	public void save(String fileName) {

		saver= new SaveFile(this.level, fileName);
		saver.action();
		this.level=saver.getLevel();
		LinkedList<String> params= new LinkedList<String>();
		params.add("SAVE");
		setChanged();
		notifyObservers(params);
	}

	@Override
	public void load(String string) {
		loader= new LoadFile(string);
		loader.action();
		this.level=loader.getLevel();
		LinkedList<String> params= new LinkedList<String>();
		params.add("DISPLAY");
		setChanged();
		notifyObservers(params);
	}

	public void setLevel(Level level){
		this.level=level;
	}

	@Override
	public void exit() {
		/*	exit= new ExitReciver();
		exit.action();
		LinkedList<String> params= new LinkedList<String>();
		params.add("EXIT");
		setChanged();
		notifyObservers(params);
	}*/

	}
}