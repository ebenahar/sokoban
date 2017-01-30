package controller.commands;

import model.Model;


public class Save  extends Command{

	private Model m;
	String fileName;
	String fileType;

	public Save(Model model) {
		this.m=model;
	}
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}



	@Override
	public void execute() {

		this.m.save(fileName);
	}
	
	public void setState(String fileName) {
		this.fileType= fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());

	}
}
