package number_theory;
import java.util.*;
public class NumberOfDivisors{
class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while(testCases > 0){
            int num = scn.nextInt();
            int divisors = getCountOfDivisors(num);
            System.out.println(divisors);
            testCases -= 1;
        }
        scn.close();
    }

    public static int getCountOfDivisors(int num){
        int count = 0;
        for(int i=1; i*i <= num; i++){
            if(num % i == 0){
                count += 1;
                if(i * i !=  num){
                    count  += 1;
                }
            }
        }
        return count;
    }
}
}