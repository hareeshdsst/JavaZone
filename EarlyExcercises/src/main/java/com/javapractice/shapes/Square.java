package com.javapractice.shapes;

public class Square extends Shape {
	double side;

	@Override
	public double getArea() {
		return side * side;
	}
	@Override
	public double getPerimeter() {
		return 4 * side;
	}

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
