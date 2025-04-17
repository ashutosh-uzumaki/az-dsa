package number_theory;
import java.util.*;  
public class DivideThePiles {
class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while(testCases > 0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = scn.nextInt();
            }
            int divideThePile = 0;
            for(int i=0; i<n; i++){
                divideThePile = gcd(divideThePile, arr[i]);
            }
            if(divideThePile > 1){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            testCases -= 1;
        }        
    }

    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }

        return gcd(b % a, a);
    }
}
}
