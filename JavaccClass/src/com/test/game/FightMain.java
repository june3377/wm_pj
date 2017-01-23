package com.test.game;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class FightMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int flag = 0;
		

/*		JavaC captain = new JavaC("민동연", 29, 1, 180, 70, 80);
		JavaC subCaptain = new JavaC("김우성", 26, 7, 177, 75, 85);*/
		
//		captain.save(captain, "captain");
//		subCaptain.save(subCaptain, "subCaptain");
		JavaC captain;
		JavaC subCaptain;

		captain = (JavaC)Member.load("captain");
		subCaptain = (JavaC)Member.load("subCaptain");
		

		print("┌──────────────────────────────┐");
		print("│                     반장과 부반장. 짱 타이틀 쟁탈전   	           │");
		print("└──────────────────────────────┘");
		
		print("	반		장		부  	반  	장 ");
		print("		"+captain.getName()+"	│			"+subCaptain.getName());
		print("age :			"+captain.getAge()+"	│	age :			"+subCaptain.getAge());
		print("major :		"+captain.getMajor()+"	│	major :		"+subCaptain.getMajor());
		print("height :		"+captain.getHeight()+"	│	height :		"+subCaptain.getHeight());
		print("weight :		"+captain.getWeight()+"	│	weight :		"+subCaptain.getWeight());
		print("codingability :	"+captain.getCodingAbility()+"	│	codingability :	"+subCaptain.getCodingAbility());
		print("");

	
		print(captain.getName() + "님은 운동을 배웠나요? 1:예 2:아니요");
		captain.increaseStrength(Integer.parseInt((scanner.nextLine())));
		print(subCaptain.getName() + "님은 운동을 배웠나요? 1:예 2:아니요");
		subCaptain.increaseStrength(Integer.parseInt((scanner.nextLine())));

		for (; flag < 5; flag++) {
			boolean tryit;
			print(captain.getName() + "의 공격!!!");
			print("	상대체력 :		" + subCaptain.getStrength());
			tryit = captain.attack(subCaptain);
			
			System.out.print("	공격력:		" + captain.getAttack());
			if (tryit == true) {
				print(" 	 **공격성공**");
				print("	상대남은체력 :	" + subCaptain.getStrength());
			} else {
				print(" 					 ##공격 실패##");
				flag = 5;
				print("	============== 상대가 죽었습니다 ===============");
				print(captain.getName()+"승리!!");

			}
			print("");
		
			if (flag != 5) {
				print(subCaptain.getName() + "의 공격!!!");
				print("	상대체력 :		" + captain.getStrength());
				tryit = subCaptain.attack(captain);
				System.out.print("	공격력:		" + subCaptain.getAttack());

				if (tryit == true) {
					print(" 	 **공격성공**");
					print("	상대남은체력 :	" + captain.getStrength());
				} else {
					print(" 				 ##공격 실패##");
					flag = 5;
					print("	============== 상대가 죽었습니다 ===============");
					print(subCaptain.getName()+"승리!!");
				}
				System.out.println("");
				if (flag == 4) {
					print("계속 공격하시겠습니까? 5번 y/n");
					if (scanner.nextLine().equals("y")) {
						flag = 0;
					}
				}
			}
		}

	}
	
	public static void print(String in){
		System.out.println(in);
	}
}
