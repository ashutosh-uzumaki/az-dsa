package modular_arithmetic;
import java.util.*;

public class ModularExponentionFermat {

class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        long testCases = scn.nextLong();
        while(testCases > 0){
            long a = scn.nextLong();
            long b = scn.nextLong();
            long c = scn.nextLong();
            long mod = scn.nextLong();
            if(b == 0 && c != 0){
                System.out.println(1);
            }
            else if(a % mod == 0 || a == 0){
                System.out.println(0);
            }else{
                long bc = exponent(b, c, mod - 1);
                long abc = exponent(a, bc, mod);

                System.out.println(abc % mod);
            }
            testCases -= 1;
        }
    }

    public static long exponent(long a, long b, long mod){
        if(b == 0){
            return 1;
        }
        long answer = exponent(a, b / 2, mod);
        if(b % 2 == 1){
            long halfAnswer = (answer % mod * answer % mod) % mod;
            long result = (halfAnswer % mod * a % mod) % mod;
            return result % mod;
        }else{
            return (answer % mod * answer % mod) % mod;
        }
    }
}
}
