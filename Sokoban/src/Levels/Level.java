package Levels;

import java.util.ArrayList;

public class Level implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int width = 0;
	private ArrayList<String> rows = new ArrayList<String>();
	private String description = "";
	public void addRow(String row) {
        rows.add(row);
        if(row.length() > width) { width = row.length(); }
    }
    public void setDescription(String desc) {
        description = desc;
    }
    public int getWidth() { return width; }
    public int getHeight() { return rows.size(); }
    public String getDescription() { return description; }
};


    