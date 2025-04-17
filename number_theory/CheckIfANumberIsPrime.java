package number_theory;
import java.util.*;
public class CheckIfANumberIsPrime {
class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while(testCases > 0){
            int n = scn.nextInt();
            boolean isPrime = checkPrime(n);
            if(isPrime){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            testCases -= 1;
        }
        scn.close();
    }

    public static boolean checkPrime(int n){
        if(n == 1){
            return false;
        }
        for(int i=2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
}
