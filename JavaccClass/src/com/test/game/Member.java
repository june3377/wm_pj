package com.test.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Member implements Serializable{
	public static void save(Member member, String filename){
		try{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(member);
			oos.flush();
			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	public static Member load(String filename){
		Member member = null;
		try{
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			member = (Member)ois.readObject();
			ois.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return member;
	}
	//필드
	private String name;
	private int age;
	private int major;
	private int height;
	private int weight;
	private int codingAbility;
	private int strength;
	
	public Member(String name, int age, int major, int height, int weight, int codingAbility) {
		super();
		this.name = name;
		this.age = age;
		this.major = major;
		this.height = height;
		this.weight = weight;
		this.codingAbility = codingAbility;
		this.strength = 100;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCodingAbility() {
		return codingAbility;
	}
	public void setCodingAbility(int codingAbility) {
		this.codingAbility = codingAbility;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	

}
