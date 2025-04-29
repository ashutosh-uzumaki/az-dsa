package greedy;

import java.util.*;

public class PrintValidParanthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            printValidParanthesis(n);
        }
    }

    static void printValidParanthesis(int n){
        for(int i=1; i<=n; i++){
            int bracket = i;
            while(bracket-- > 0){
                System.out.print("(");
            }
            bracket = i;
            while(bracket-- > 0){
                System.out.print(")");
            }
            bracket = n - i;
            while(bracket-- > 0){
                System.out.print("()");
            }
            System.out.println();
        }
    }
}

