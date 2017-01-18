package newbase;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class NewBaseball2 extends JFrame implements ActionListener {
	
	private JOptionPane jop = new JOptionPane();
	private JButton bt = new JButton("확인");
	private URL imgURL = this.getClass().getResource("img.jpg");
	private JLabel lb = new JLabel("감사합니다",JLabel.CENTER);
	private ImageIcon image1 = new ImageIcon(imgURL);
	private Font font = new Font("돋음", Font.BOLD, 30);
	
	static Baseball tt = new Baseball();
	
	NewBaseball2(){
		this.init();
		this.start();
		this.setVisible(true);
		this.setSize(200, 350);
	}
	
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init() {
		Container con = getContentPane();
		BorderLayout bd = new BorderLayout();
		con.setLayout(bd);
		
		Panel p1 = new Panel(new GridLayout(2,1));
		
		lb.setFont(font);
		p1.add(lb);
		p1.add(new JLabel("굿!!", image1, JLabel.CENTER));
		con.add(p1);
	}
	
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
					new NewBaseball2();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}