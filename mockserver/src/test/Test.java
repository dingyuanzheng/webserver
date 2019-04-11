package test;


public class Test {

	/**
	 * @param 场景
	 * 初始化：100个人，每个人100元
	 * 事件：每个人随机给另外一个人转账2元 ，每个人转账10000次
	 * 结果：最后这100个人是否是平等金额？
	 */
	public static void main(String[] args) {
//		int persion = 0;
//		int[] persons = new int[100];
//		for(int i = 0 ; i < persons.length ; i ++) {
//			persons[i] = 100;
//		}
//		System.out.println("开始转账...");
//		for(int i = 0 ; i < 10000 ; i ++) {
//			for(int j = 0 ; j < persons.length ; j ++) {
//				persons[j] -= 2;
//				persion = (int)(Math.random() * persons.length);
//				persons[persion] += 2;
//			}
//		}
//		System.out.println("转账結束...");
//		for(int i = 0 ; i < persons.length ; i ++) {
//			System.out.println("朋友：" + i + "剩余的钱：" + persons[i] + "元");
//		}
		
		
		//1e3 * (Math.round(Math.random() * (i - t)) + t)
		
		System.out.println(new Test().getRandom(1 , 4));
		
	}
	
	private long getRandom(int t, int i) {
		return (int)(1e3 * (Math.round(Math.random() * (i - t)) + t));
	}
}
