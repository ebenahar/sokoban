package view;

import model.data.Level;

public interface View {

	public void display(Level level);

	public void start();

	public void moveMade();

	public void levelFinshed();

	public void displayMessage(String msg);

	//public void setLevel(LevelReadOnly level);
}