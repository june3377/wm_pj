package newbase;

import java.util.Scanner;

public class NewBaseball2 {
	static int[] realnum = new int[3];
	static Baseball tt = new Baseball();

	public static void main(String[] args) {
		tt.random();

		Scanner scanner = new Scanner(System.in);
		System.out.println("┌──────────────────────────────────────────────────────┐");
		System.out.println("│                    Play Ball                         │");
		System.out.println("└──────────────────────────────────────────────────────┘");
		System.out.println();

		while (true) {

			System.out.print("숫자 3개를 입력해주세요 ex(1 2 3)");
			String line = scanner.nextLine();
			String[] num = line.split(" ");

			for (int i = 0; i < realnum.length; i++) {
				realnum[i] = Integer.parseInt(num[i]);

			} // for문 끝
			if (realnum[0] == realnum[1] && realnum[2] == realnum[0] && realnum[2] == realnum[1]) {
				System.out.println("중복된 숫자를 입력하셨습니다.");
				continue;
			}

			System.out.println("다시입력하세요!!");

			/* tt.getRd_num(); */
			tt.ball(realnum);
			tt.strike(realnum);

			System.out.println(" 스트라이크 " + tt.getStrike_cnt() + " 볼 " + tt.getBall_cnt());
			System.out.println();

			tt.b_try();

			if (tt.getStrike_cnt() == 3) {
				System.out.println("당신은 " + tt.getTry_cnt() + "번만에 맞추셨습니다.");
				tt.random();
				System.out.println("축하합니다 ^^");
				System.out.println("계속하시겠습니까? y/n 정답보면서하기 cheat");

				String input = scanner.nextLine();

				if (input.equals("n")) {
					System.out.println("당신의 이름은?");
					tt.setHm(scanner.nextLine());
					System.out.println("플레이어 명단");
					System.out.println(tt.getHm());
					break;
				} else if (input.equals("y")) {
					System.out.println("당신의 이름은?");
					tt.setHm(scanner.nextLine());
					tt.rank_up();
					tt.newgame();
					System.out.println("등록 되었습니다 ^^");
				} else if (input.equals("cheat")) {
					tt.getRd_num();
					tt.newgame();

				}
			}
		}
	}
}