package model.data.loaders;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.data.Level;
import model.policy.MySokobanPolicy;


public class MyTextLevelLoader extends MyLevelLoader{

	public MyTextLevelLoader(InputStream inputStream){
		this.inputStream=inputStream;
	}

	public Level loadLevel(){
		String line;
		String result = new String();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			line=br.readLine();
			while(line!=null){
				result=result+line+"\n";
				line = br.readLine();
			}
		} catch(Exception exception){
		};
		
		level = new Level(result,new MySokobanPolicy());
		return level;
	}
}