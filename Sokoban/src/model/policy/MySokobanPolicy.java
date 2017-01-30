package model.policy;

import java.io.Serializable;

public class MySokobanPolicy implements Policy, Serializable{

	private static final long serialVersionUID = 1L;
	public MySokobanPolicy(){
	}
	
	public boolean passThroughWall(){
		return false;
	}
	
	public boolean pushBlockedBox(){
		return false;
	}
}