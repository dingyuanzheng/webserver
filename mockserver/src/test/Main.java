package test;

public class Main {
	
	public static void main(String[] args) {
	
		int[] num = new int[]{3,4,5};
		int[] rem = new int[]{2,3,1};
		System.out.println(new Main().gcd(num , rem));
		
	}
    
	public int gcd(int[] num , int[] rem) {
		int lcm = 1;
		for(int i = 0 ; i < num.length ; i ++) {
			lcm = lcm * num[i];
		}
		int[] abc = new int[num.length];
		int[] cde = new int[num.length];
		for(int i = 0 ; i < num.length ; i ++) {
			//计算乘机
			abc[i] = lcm / num[i];
			//求余
			if(abc[i] % num[i] != rem[i]) {
				cde[i] = abc[i] % num[i] * rem[i];
			}else {
				cde[i] = abc[i];
			}
		}
		int total = 0;
		for(int i = 0 ; i < cde.length ; i ++) {
			total += cde[i];
		}
		
		
		return Math.abs(total - lcm);
	}

}
