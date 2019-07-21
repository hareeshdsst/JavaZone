package com.javapractice.examples2;

public class House3D {

	private String title, designer;
	
	private int x, y, z;
	private ModelObject[] models;

	
	public House3D(String title, String desinger) {
		this.title = title;
		this.designer = desinger;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public ModelObject[] getModels() {
		return models;
	}

	public void setModels(ModelObject[] models) {
		this.models = models;
	}
	
}
