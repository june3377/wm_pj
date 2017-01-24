package com.test.fightgame;

import java.util.Date;

public class Person {
	//필드
	private int no;
	private String name;
	private char gender;
	private int height;
	private int weight;
	private int major;
	private int city;
	private Date created_at;
	
	//생성자
	public Person(int no, String name, char gender,int height, int weight, int major, int city){
		setNo(no); setName(name); setGender(gender); 
		setHeight(height); setWeight(weight); 
		setMajor(major); setCity(city); 
		this.created_at = new Date();
	}
		

	//set, get
	public void setNo(int no) { this.no = no; }
	public int getNo() { return this.no; }
	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	public void setGender(char gender) { this.gender = gender; }
	public char getGender() { return this.gender; }
	public void setHeight(int height) {	this.height = height; }
	public int getHeight() { return height;	}
	public void setWeight(int weight) { this.weight = weight;	}
	public int getWeight() { return weight; }
	public void setMajor(int major) { this.major = major; }
	public int getMajor() { return this.major; }
	public void setCity(int city) { this.city = city; }
	public int getCity() { return this.city; }
	public Date getDate() { return this.created_at; } //언제 생성되는지만 가지고 있어야하므로 바꿀 수 없게 한다.

}
