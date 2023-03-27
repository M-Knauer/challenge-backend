package com.marcelo.main.entities;

import java.io.Serializable;

public class Dimension implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double weight;
    private double height;
    private double width;
    private double length;
    
    public Dimension() {

	}

	public Dimension(double weight, double height, double width, double length) {
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
    
}
