package model.data.savers;

import model.data.Level;

public abstract class MyLevelSaver implements LevelSaver{
	
	public String file;
	public Level level;
	
	@Override
	public abstract void saveLevel();
}