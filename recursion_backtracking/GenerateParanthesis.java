package recursion_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateParanthesis {
    class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        generateParanthesis(0, 0, new StringBuilder(), n);
    }

    public static void generateParanthesis(int open, int close, StringBuilder paranthesis, int n){
        if(paranthesis.length() == n){
            System.out.println(paranthesis.toString());
            return;
        }

        if(open < n/2){
            paranthesis.append('(');
            generateParanthesis(open+1, close, paranthesis, n);
            paranthesis.deleteCharAt(paranthesis.length() - 1);
        }

        if(close < open){
            paranthesis.append(')');
            generateParanthesis(open, close + 1, paranthesis, n);
            paranthesis.deleteCharAt(paranthesis.length()-1);
        }
    }
}
}
