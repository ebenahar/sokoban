package model.data.loaders;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import model.data.Level;

public class MyObjectLevelLoader extends MyLevelLoader{

	
	public MyObjectLevelLoader(InputStream inputStream) {

		this.inputStream=inputStream;
	
	}
	public Level loadLevel() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(this.inputStream);
			return (Level)objIn.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}