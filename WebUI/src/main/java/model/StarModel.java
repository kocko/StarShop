package model;

import object.star.Star;

public class StarModel {
	private Star star;
	
	public String getName(){
		return star.getName();
	}
	
	public String getTitle(){
		return star.getTitle();
	}
	
	public String getDescription(){
		return star.getDescription();
	}
	
	public String getPhotoUrl(){
		return "";
	}
}

