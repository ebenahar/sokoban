package model.data.savers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import model.data.Level;

public class SaveTxt extends MyLevelSaver{

	public SaveTxt(Level level, String fileName){
		this.level=level;
		this.file=fileName;

	}
	@Override
	public void saveLevel(){
		try{
			OutputStream o= new FileOutputStream(new File(file));
			o.write(level.getLevel().getBytes());
		} catch (IOException exception){
			exception.printStackTrace();
		}
		System.out.println("dont forget to close the file!");
	}
}