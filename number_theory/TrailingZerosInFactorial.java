package number_theory;


public class TrailingZerosInFactorial{
    class Solution {
        static int trailingZeroes(int n) {
            int count = 0;
            while(n >= 5){
                count = count + (n / 5);
                n = n / 5;
            }
            return count;
        }
    }
}