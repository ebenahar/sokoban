package model.data.loaders;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.beans.XMLDecoder;
import model.data.Level;


public class MyXMLLevelLoader extends MyLevelLoader{

	public MyXMLLevelLoader(InputStream inputStream){
		this.inputStream=inputStream;
	}
	
	public Level loadLevel(){

		XMLDecoder d = new XMLDecoder(new BufferedInputStream(inputStream));
		this.level = (Level) d.readObject();
		d.close();
		return level;
	}
}