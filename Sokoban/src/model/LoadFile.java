package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import model.data.Level;
import model.data.loaders.MyLevelLoader;
import model.data.loaders.MyObjectLevelLoader;
import model.data.loaders.MyTextLevelLoader;
import model.data.loaders.MyXMLLevelLoader;


public class LoadFile{

	private String type;
	private Level level;
	String is;

	public LoadFile(String type){
		super();
		this.type = type;
		this.is = type;
	}

	public void action() {
		setState(type);
		HashMap<String, MyLevelLoader> fileTypes=	new HashMap<String, MyLevelLoader>();
		try {
			fileTypes.put("txt", new MyTextLevelLoader(new FileInputStream(is)));
			fileTypes.put("xml", new MyXMLLevelLoader(new FileInputStream(is)));
			fileTypes.put("obj", new MyObjectLevelLoader(new FileInputStream(is)));
			this.level=fileTypes.get(type).loadLevel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setState(String fileName) {
		this.type= fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	}

	public Level getLevel() {

		return this.level;
	}

}