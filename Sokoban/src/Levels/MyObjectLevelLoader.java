package Levels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MyObjectLevelLoader implements LevelLoader{
	public void loadLevel() {
	Level l = null;
	try  {
		System.out.println("Creating File/Object input stream...");
		FileInputStream fileIn = new FileInputStream("level.txt");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		
		
		System.out.println("Loading level...");
		l = (Level)in.readObject();
		
		System.out.println("Load Successful...\n");
		in.close();
		fileIn.close();
		
	} catch (ClassNotFoundException e) {
		System.out.println("Class not found\n");
		e.printStackTrace();
	} catch(FileNotFoundException e) {
		System.out.println("File not found\n");
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	
	}
	}
	
}
