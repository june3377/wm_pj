package game;

import java.util.Scanner;

public class FightMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		JavaC captain = new JavaC("민동연",29,1,180,70,80);
		JavaC subCaptain = new JavaC("김우성",26,7,177,75,85);
		
		System.out.println("-----------반장과 부반장. 짱 타이틀 쟁탈전---------");
		System.out.println(captain.getName()+"님은 운동을 배웠나요? 1:예 2:아니요");
		captain.increaseStrength(Integer.parseInt((scanner.nextLine())));
		System.out.println(subCaptain.getName()+"님은 운동을 배웠나요? 1:예 2:아니요");
		subCaptain.increaseStrength(Integer.parseInt((scanner.nextLine())));
		
		System.out.println(captain.getName()+"공격합니다");
		System.out.println("공격력:"+captain.getAttack());
		System.out.println(captain.attack(subCaptain));
		System.out.println("남은체력 : "+subCaptain.getStrength());
		
		System.out.println(subCaptain.getName()+"공격합니다");
		System.out.println("공격력:"+subCaptain.getAttack());
		System.out.println(subCaptain.attack(captain));
		System.out.println("남은체력 : "+captain.getStrength());
		
	}

}
