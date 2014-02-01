package fares.myapps.sinktheships.gamelogic;

import java.util.ArrayList;

public class Ship {

	private String name;
	private ArrayList<String> location;
	
	Ship(){
		this.name = "";
		this.location = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation(int index) {
		return location.get(index);
	}

	public void setLocation(String location) {
		this.location.add(location);
	}
	
	
}
