package com.au.spring;


import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Triangle {

	private Map<String, Point> points;

	private Set<Point> set_points ;




	public void setSet_points(Set<Point> s){
		this.set_points=s;
	}

	public Set<Point> getSet_points(){
		return set_points;
	}

	public Map<String, Point> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}

	public Triangle(Map<String, Point> points) {
		this.points = points;
	}

	public Triangle() {
	}

	public void draw() {
		System.out.println("\nMap of Points:");
		for (Map.Entry<String, Point> entry : this.getPoints().entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}

		System.out.println("\n set of points: "+ this.getSet_points());

	}


}
