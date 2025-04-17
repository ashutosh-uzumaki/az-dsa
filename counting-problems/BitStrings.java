import java.util.*;

public class BitStrings{
	static long mod = (long)(1e9 + 7);
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		long getCount = pow(2, n);
		System.out.println(getCount);
        scn.close();
	}

	public static long pow(long x, long n){
		if(n == 0){
			return 1;
		}

		long ans = pow(x, n / 2);
		if(n % 2 == 1){
			long currHalf = (ans % mod * ans % mod) % mod;
			long res = (currHalf % mod * x % mod) % mod;
			return res;
		}else{
			long res = (ans % mod * ans % mod) % mod;
			return res;
		}
	}

}