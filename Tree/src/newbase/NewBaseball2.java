package newbase;

import java.util.Scanner;


public class NewBaseball2 {
	
	static Baseball tt = new Baseball();
	
	public static void main(String[] args) {
		tt.random();
		
		Scanner scanner = new Scanner(System.in);
		print("┌──────────────────────────────────────────────────────┐");
		print("│                    Play Ball                         │");
		print("└──────────────────────────────────────────────────────┘");
		print("당신의 이름은?");
		tt.setHm(scanner.nextLine());
		print("등록 되었습니다 ^^");

		while (true) {
			
			System.out.print("숫자 3개를 입력해주세요 ex(1 2 3)");
			String line = scanner.nextLine();
			tt.input(line);
			
			tt.ball();
			tt.strike();

			print(tt.getRd_num());
			print(" 스트라이크 " + tt.getStrike_cnt() + " 볼 " + tt.getBall_cnt());
			tt.b_try();

			if (tt.getStrike_cnt() == 3) {
				System.out.println("당신은 " + tt.getTry_cnt() + "번만에 맞추셨습니다.");
				tt.random();
				print("축하합니다 ^^");
				print("계속하시겠습니까? y/n 정답보면서하기 cheat");

				String input = scanner.nextLine();
				if (input.equals("n")) {
					print(tt.getHm()+"님 감사합니다.");
					break;
				} else if (input.equals("y")) {
					tt.rank_up();
					tt.newgame();
				} else if (input.equals("cheat")) {
					print(tt.getRd_num());
					tt.newgame();
				}
			}
		}
	}
	
	public static void print(String in){
		System.out.println(in);
	}

}