package newbase;

import java.util.HashMap;

public class Baseball {

	private int try_cnt;
	private int strike_cnt;
	private int ball_cnt;
	private int[] rd_num;
	private int[] realnum;
	private HashMap<Integer, String> hm = new HashMap();
	private int rank;
	static final int TOINTVALUE = 10;

	public Baseball() {
		this.try_cnt = 0;
		this.strike_cnt = 0;
		this.ball_cnt = 0;
		this.rd_num = new int[3];
		this.realnum = new int[3];
	}
	
	public void input(String line){
		String[] num = line.split(" ");
		
		for (int i = 0; i < realnum.length; i++) {
			realnum[i] = Integer.parseInt(num[i]);
		}
		
	}

	public void ball() {
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
		ball_cnt = ball;
	}

	public void strike() {
		int strike = 0;
		for (int i = 0; i < rd_num.length; i++) {
			if (rd_num[i] == realnum[i]) {
				strike++;
			}
		}
		strike_cnt = strike;
	}

	public void random() {
		while (true) {
			int num1 = (int) (Math.random() * TOINTVALUE);
			int num2 = (int) (Math.random() * TOINTVALUE);
			int num3 = (int) (Math.random() * TOINTVALUE);
			if (num1 != num2 && num3 != num1 && num3 != num2) { // 중복안되게
				rd_num[0] = num1;
				rd_num[1] = num2;
				rd_num[2] = num3;
				break;
			}
		}
	}

	public void b_try() {
		try_cnt++;
	}

	public int getTry_cnt() {
		return try_cnt;
	}

	public int getStrike_cnt() {
		return strike_cnt;
	}

	public int getBall_cnt() {
		return ball_cnt;
	}

	public String getRd_num() {
		String cheat = "답은";
		cheat += rd_num[0];
		cheat += rd_num[1];
		cheat += rd_num[2];
		
		return cheat;
	}

	public String getHm() {
		if(hm.get(1) == null) return hm.get(0);
		if(hm.get(2) == null) return hm.get(0) + hm.get(1);
		return hm.get(0)+","+ hm.get(1)+","+ hm.get(2);
	}

	public void setHm(String name) {
		this.hm.put(rank, name);
	}
	
	public void rank_up(){
		if(rank==3){
			rank=0;
		}
		rank++;
	}
	public void newgame(){
		this.try_cnt=0;
	}
	public int getRd_numLength(){
		return rd_num.length;
	}
	public void modifyRd_num(int index, int value){
		this.rd_num[index] = value;
	}
	public int getRd_num(int index){
		return rd_num[index];
	}
	public void removeRd_num(){
		for(int i=0 ; i<rd_num.length ; i++) rd_num[i]=0;
	}
	public int getRealnumLength(){
		return realnum.length;
	}
	public void modifyRealnum(int index, int value){
		this.realnum[index] = value;
	}
	public int getRealnum(int index){
		return realnum[index];
	}
	public void removeRealnum(){
		for(int i=0 ; i<realnum.length ; i++) realnum[i]=0;
	}
}
