package com.cdac.singer.model;

public class Singer {
	
	private int id;
	private String name;
	private String type;
	
	
	
	public Singer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Singer(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
		

}
