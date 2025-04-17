import java.util.*;

public class LuckyNumbers{
	//CONTAINS ONLY 7, 8 IN DIGITS
	// static long mod = (long)(1e9 + 7);
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long getCount = 0;
		for(int i=1; i<=n; i++){
			getCount += pow(2, i);
		}
		System.out.println(getCount);
		scn.close();
	}

	public static long pow(long x, long n){
		if(n == 0){
			return 1;
		}

		long ans = pow(x, n / 2);
		if(n % 2 == 1){
			return ans * ans * x;
		}else{
			return ans * ans;
		}
	}

}

