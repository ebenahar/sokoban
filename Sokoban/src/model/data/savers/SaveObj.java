package model.data.savers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import model.data.Level;
import java.io.File;
import java.io.FileOutputStream;


public class SaveObj extends MyLevelSaver{

	public SaveObj(Level level, String file){
		this.file=file;
		this.level=level;
	}
	
	@Override
	public void saveLevel(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(this.file)));
			out.writeObject(level);
			out.close();
		}catch(IOException i){
			i.printStackTrace();
		}
	}
}