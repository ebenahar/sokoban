package model;

import java.util.HashMap;

import model.data.Level;
import model.data.savers.MyLevelSaver;
import model.data.savers.SaveObj;
import model.data.savers.SaveTxt;
import model.data.savers.SaveXml;

public class SaveFile{

	private Level level;
	//private OutputStream outputStream;
	private String fileName;
	private String type;

	public Level getLevel(){
		return level;
	}
	
	public void setLevel(Level level){
		this.level = level;
	}

	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public SaveFile(Level level,String fileName){

		this.level=level;
		this.fileName=fileName;
	}
	
	public void action(){
		setState(fileName);
		HashMap<String, MyLevelSaver> fileTypes=new HashMap<String, MyLevelSaver>();
		fileTypes.put("txt", new SaveTxt(this.level,this.fileName));
		fileTypes.put("xml", new SaveXml(this.level,this.fileName));
		fileTypes.put("obj", new SaveObj(this.level,this.fileName));
		MyLevelSaver gls=fileTypes.get(type);
		gls.saveLevel();
	}

	public void setState(String fileName){
		this.type= fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	}
}