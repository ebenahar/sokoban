
package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.SokobanController;
import model.MyGameModel;
import view.MyGameView;

public class Run {

	public static void main(String[] args) {

		MyGameModel model=new MyGameModel();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		MyGameView view= new MyGameView(reader,writer,"Exit");
		SokobanController controller=new SokobanController(model,view);
		model.addObserver(controller);
		view.addObserver(controller);
		view.start();
	}
}
