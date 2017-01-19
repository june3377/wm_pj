package game;

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
			int life = this.getStrength() + 5;
			this.setStrength(life);
		}
	}

	public void increaseAttack() {
		if (this.getMajor() == 1) {
			this.attack += 20;
		} else {
			this.attack += 10;
		}
	}
	

	public boolean attack(JavaC name) {
		
		
		
		System.out.println("공격받는애 체력" + name.getStrength());
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
