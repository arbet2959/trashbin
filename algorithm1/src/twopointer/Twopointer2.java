package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1940
public class Twopointer2 {
  public static void main(String[] args) throws IOException {
	  BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
	  int n = Integer.parseInt(bf.readLine());
	  int m = Integer.parseInt(bf.readLine());
	  int[] a = new int[n];
	  StringTokenizer st = new StringTokenizer(bf.readLine());
	  for (int i=0;i<n;i++) {
		  a[i] = Integer.parseInt(st.nextToken());
	  }
	  Arrays.sort(a);
	  int count=0, i=0, j=n-1;
	  while(i<j) {
		  if(a[i]+a[j]<m) {
			  i++;
		  }else if(a[i]+a[j]>m) {
			  j--;
		  }else {
			  count++;
			  j--;
		  }
	  }
	  System.out.println(count);
	  bf.close();
	  
	  
  }
}
