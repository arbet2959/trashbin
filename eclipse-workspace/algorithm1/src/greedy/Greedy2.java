package greedy;

import java.util.Scanner;

// 그리디알고리즘
// 백준 1541
public class Greedy2 {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String example = sc.nextLine();
		String[] str = example.split("-");
		for(int i=0;i<str.length;i++) {
			int temp = mySum(str[i]);
			if (i==0) answer = answer +temp;
			else answer = answer -temp;
		}
		System.out.println(answer);
		sc.close();
	}//메인종료
	private static int mySum(String str) {
		int sum =0;
		String temp[] = str.split("[+]"); //조심
		for(int i =0; i<temp.length;i++) {
			sum+=Integer.parseInt(temp[i]);
		}
		return sum;
	}
	
	
}
