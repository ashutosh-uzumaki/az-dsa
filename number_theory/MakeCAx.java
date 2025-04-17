package number_theory;

import java.util.Scanner;

public class MakeCAx+ByEqualsC {
    class Main{
        public static void main(String[] args){
            Scanner scn = new Scanner(System.in);
            int testCases = scn.nextInt();
            while(testCases > 0){
                int a = scn.nextInt();
                int b = scn.nextInt();
                int c = scn.nextInt();
    
                int gcd = calculateGcd(a, b);
                if(c % gcd == 0){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
                testCases -= 1;
            }
            scn.close();
        }
    
        public static int calculateGcd(int a, int b){
            if(a == 0){
                return b;
            }
            return calculateGcd(b % a, a);
        }
    }
}

//INTUTION -> BEZOUT'S IDENTITY -> IF gcd(a, b) divides c then solution is possible
