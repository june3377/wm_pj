package com.test.game;

public class JavaC extends Member implements LearnSports {
	private int attack;
	private int defence;

	public JavaC(String name, int age, int major, int height, int weight, int codingAbility) {
		super(name, age, major, height, weight, codingAbility);
		super.setStrength(100);
		this.attack = 0;
		this.defence = 0;

		increaseAttack();
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	@Override
	public void increaseStrength(int a) {
		if (a == 1) {
			int life = this.getStrength() + 3;
			this.setStrength(life);
		}
	}

	public void increaseAttack() {
		if (this.getMajor() == 1) {
			this.attack = (int)(this.getWeight()*(0.2));
		} else {
			this.attack = (int)(this.getWeight()*(0.18));
		}
	}
	
	public int random(){
		int rand = (int) (Math.random() * 10);
		//System.out.println("행운 : "+rand);
		return rand;
	}

	public boolean attack(JavaC name) {
		if(random() == 7){
			this.attack += this.attack*0.5;
		}
		
		int life = name.getStrength() - this.attack;

		if (life < 0) {
			return false;
		}
		name.setStrength(life);
		return true;

	}

	public void defence() {

	}

}
