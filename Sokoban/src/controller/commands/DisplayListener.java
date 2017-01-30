
package controller.commands;

import model.data.Level;

public class DisplayListener{

	Level level;
	public DisplayListener(Level level){
		this.level=level;
	}

	public void action(){
		this.level.printToScreen();
	}
}