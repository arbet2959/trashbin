package etc;



public class FindPrime {
	public static void main(String[] args) {
		int cnt  = 0 ;
		int[] prime = new int[500];
		int ptr = 0;
		prime[ptr++] = 2;
		prime[ptr++] = 3;
		
		for (int n=5; n<=1000; n +=2) {
			boolean flag = true;
			int i;
			for(i=1; prime[i]*prime[i]<=n;i++) {
				cnt+=2;
				if(n%prime[i]==0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				prime[ptr++]=n;
				cnt++;
			}
		}
		
		for(int i=0;i<ptr;i++) {
			System.out.println(prime[i]);
		}
		System.out.println(cnt);
		
	
	}
}
