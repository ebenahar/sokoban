package controller;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import controller.commands.Command;

public  class Controller {

	private BlockingQueue<Command> queue;
	private boolean stop=false;

	public Controller() {
		queue= new ArrayBlockingQueue<Command>(10);
	}

	public void insertCommand(Command c){
		try {
			queue.put(c);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void start(){
		Thread thread= new Thread(new Runnable() {

			public void run() {
				while(!stop)
				{

					Command cmd;
					try {
						cmd = queue.poll(1,TimeUnit.SECONDS);
						if(cmd!=null)
							cmd.execute();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}

			}
		});thread.start();
			}

	public void stop(){
		stop=true;
	}
}



//
//
//
//package Controller.General;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//
//public class Controller {
//
//	private BlockingQueue<ICommand> queue;
//	private boolean stop = false;
//	
//	public Controller() {
//		queue = new ArrayBlockingQueue<ICommand>(10);
//	}
//	public void insertCommand(ICommand cmd) {
//		try {
//			queue.put(cmd);
//		} catch (InterruptedException e) {			
//			e.printStackTrace();
//		}
//	}
//	
//	public void start() {
//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while (!stop) {
//					try {
//						ICommand cmd = queue.take();
//						if (cmd != null)
//							//System.out.println(cmd.getClass().getName());
//							cmd.execute();						
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		});
//		thread.start();
//	}
//	
//	public void stop() {
//		stop = true;
//	}
//}