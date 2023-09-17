package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 12891
public class SlidingWindow {
	static int checkArr[];
	static int myArr[];
	static int result=0;
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken()); //전체문자열길이 t
		int p = Integer.parseInt(st.nextToken()); //자른문자열길이 p
		result = 0; //결과
		char dna[] = new char[t];  // 주어진 dna배열 t길이
		
		myArr= new int[4]; 
		checkArr = new int[4]; // myArr배열의 각 값이 checkArr보다 같거나크면 result가 올라감
		
		dna = bf.readLine().toCharArray();
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<4;i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
		} // checkArr배열 주어진거받음
		
		for(int i=0; i<p;i++) { 
			add(dna[i]);
		} //dna배열을 p길이에 맞춰 넣으면서 myArr값을 변화시키는 add메소드;
		check(); //  myArr과checkArr을 비교해서 일치하면 result를 ++시킬 check메소드
		
		for(int i=p; i<t;i++) { 
			int j= i-p;
			add(dna[i]);
			remove(dna[j]);
			check();
		} // 슬라이딩윈도우활용해서 답구하기
		System.out.println(result);
		bf.close();
	}
		private static void add(char c) {
			switch(c) {
			case 'A': myArr[0]++; break;
			case 'C': myArr[1]++; break;
			case 'G': myArr[2]++; break;
			case 'T': myArr[3]++; break;
			}
		}
		private static void remove(char c) {
			switch(c) {
			case 'A': myArr[0]--; break;
			case 'C': myArr[1]--; break;
			case 'G': myArr[2]--; break;
			case 'T': myArr[3]--; break;
			}
		}
		public static void check() {
			if(myArr[0]>=checkArr[0] &&
		       myArr[1]>=checkArr[1] &&
		       myArr[2]>=checkArr[2] &&
		       myArr[3]>=checkArr[3]) {
			result++;
			
		    }	
		}
		
		
			
		
		
		
		
		
	
	
	
	}

