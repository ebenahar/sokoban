package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.data.Level;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class GameDisplay extends Canvas{

	private Level level;

	private HashMap<Character, Image> objectsImage;
	GraphicsContext gc = getGraphicsContext2D();

	public GameDisplay()
	{
		setLevel(null);
	}


	public GameDisplay(Level level) {
		setLevel(level);
	}

	public void setLevel(Level level) {
		this.level = level;
		redraw();
	}

	public Level getLevel() {
		return level;
	}


	public void redraw(){
		if(this.level!=null && !this.level.levelValidate())
		{
			System.out.println("Invalid level");
			return;
		}
		try {
			Image floor=new Image(new FileInputStream(".//resources//floor.png"));
			Image wall=new Image(new FileInputStream(".//resources//wall.jpg"));
			Image player=new Image(new FileInputStream(".//resources//player.png"));
			Image box=new Image(new FileInputStream(".//resources//box.png"));
			Image target=new Image(new FileInputStream(".//resources//target.png"));
			Image bt= new Image(new FileInputStream(".//resources//bt.png"));
			Image pt=new Image(new FileInputStream(".//resources//pt.png"));
			

			objectsImage= new HashMap<Character,Image>();
			objectsImage.put('@', box);
			objectsImage.put('A', player);
			objectsImage.put('o', target);
			objectsImage.put(' ',floor);
			objectsImage.put('#', wall);
			objectsImage.put('!', pt);
			objectsImage.put('$', bt);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		char key;
		if(level==null)
			return;
		int longestrow=0;
		for(int i=0;i<level.getMatrix().length;i++)
			if(level.getMatrix()[i].length>longestrow){
				longestrow=level.getMatrix()[i].length;
			}

		double W = getWidth();
		double H = getHeight();
		double w=W/this.level.GetXmax(this.level.getLevel());
		double h=H/this.level.GetYmax(this.level.getLevel());

		/*double w =W/this.level.GetXmax(this.level.getLevel());
		double h =H/this.level.GetYmax(this.level.getLevel());*/
		//System.out.println(this.level.GetXmax(this.level.getLevel());
		//double size = W / Math.max(this.level.getMatrix().length, this.level.getMatrix()[0].length);

		gc.clearRect(0, 0, W, H);
		gc.setFill(Color.WHITESMOKE);
		gc.fillRect(0, 0, W, H);

		for(int i=0;i<this.level.GetYmax(this.level.getLevel());i++){
			for(int j=0;j<this.level.GetXmax(this.level.getLevel());j++){
				if(this.level.getMatrix()[j][i]!=null){
					key=this.level.getMatrix()[j][i].getSymbol();
					gc.drawImage(this.objectsImage.get(key),j*w, i*h,w,h);

				}
			}
		}
	}


	public void clearCanvas() {

				gc.clearRect(0, 0, getWidth(), getHeight());
			}

}