package stackque;

import java.util.Scanner;
import java.util.Stack;

//백준 1874번
public class Stack1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n;i++) {
			a[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();
		int num=0; //오름차순자연수로 쓸것
		boolean result = true;
		for (int i=0; i<a.length;i++) {
			int su =a[i];
			if (su>=num) {
				while (su >=num) {
				stack.push(num++);
				bf.append("+\n");
				}
			stack.pop();
			bf.append("+\n");
			} else {
				int n1 = stack.pop();
				if (n1>su) {
					System.out.println("can't solve");
					result = false;
					break;
				} else {
					bf.append("+\n");
				}	
			}
		}
		
	if (result) System.out.println(bf.toString());
	sc.close();
	
	}
}
