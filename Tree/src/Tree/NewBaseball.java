package Tree;
import java.util.Scanner;

public class NewBaseball {
	static int[] realnum = new int[3];
	static int[] rd_num = new int[3];
	static int try_cnt = 0;
	static int strike_cnt = 0;
	static int ball_cnt = 0;

	public static void main(String[] args) {
		random();

		Scanner scanner = new Scanner(System.in);
		System.out.println("########################################################");
		System.out.println("#                   play ball                          #");
		System.out.println("########################################################");
		System.out.println();

		while (true) {
			System.out.print("숫자 3개를 입력해주세요 ex(1 2 3)");
			String line = scanner.nextLine();
			String[] num = line.split(" ");

			for (int i = 0; i < realnum.length; i++) {
				realnum[i] = Integer.parseInt(num[i]);
			} // for문 끝

			if ( realnum[0] == realnum[1] || realnum[2] == realnum[0] || realnum[2] == realnum[1]) {
				System.out.println("중복된 숫자를 입력하셨습니다.");
				continue;
			}
					
			/*System.out.println("랜덤숫자:" + rd_num[0] + "" + rd_num[1] + "" + rd_num[2]);*/

			strike_cnt = strike(realnum, rd_num);
			ball_cnt = ball(realnum, rd_num);

			System.out.println(" 스트라이크 " + strike_cnt + " 볼 " + ball_cnt);
			System.out.println();
			try_cnt++;

			if (strike_cnt == 3) {
				System.out.println("당신은 " + try_cnt + "번만에 맞추셨습니다.");
				random();
				System.out.println("축하합니다 ^^");
				System.out.println("계속하시겠습니까? y/n");
				
				if (scanner.nextLine().equals("n")){
					break;
				}
				try_cnt = 0;

			}

		}

	}

	static int ball(int realnum[], int rd_num[]) {
		int ball = 0;
		for (int i = 0; i < rd_num.length; i++) {
			for (int j = 0; j < rd_num.length; j++) {
				if (i == j)
					continue;
				else {
					if (rd_num[i] == realnum[j]) {
						ball++;
					}
				}
			}
		}
		return ball;
	}

	static int strike(int realnum[], int rd_num[]) {
		int strike = 0;
		for (int i = 0; i < rd_num.length; i++) {
			if (rd_num[i] == realnum[i]) {
				strike++;
			}
		}
		return strike;
	}

	static void random() {
		while (true) {
			int num1 = (int) (Math.random() * 10);
			int num2 = (int) (Math.random() * 10);
			int num3 = (int) (Math.random() * 10);
			if (num1 != num2 && num3 != num1 && num3 != num2) { // 중복안되게
				rd_num[0] = num1;
				rd_num[1] = num2;
				rd_num[2] = num3;
				break;
			}
		}

	}

}
