package model.data.savers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import model.data.Level;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;


public class SaveXml extends MyLevelSaver{


	public SaveXml(Level level,String file){
		this.level=level;
		this.file=file;
	}
	
	@Override
	public void saveLevel(){
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(this.file))));
			encoder.writeObject(this.level);
			encoder.close();
		} 
		catch (FileNotFoundException exception){
			exception.printStackTrace();
		}
	}
}