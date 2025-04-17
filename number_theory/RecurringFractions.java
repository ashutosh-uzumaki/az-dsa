package number_theory;

import java.util.*;

public class RecurringFractions {

class Main {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0"; // Case when numerator is 0

        StringBuilder result = new StringBuilder();

        // Handle negative numbers
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }

        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) return result.toString(); // No decimal part

        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            // If we have seen this remainder before, we found a cycle
            if (remainderMap.containsKey(remainder)) {
                int startIndex = remainderMap.get(remainder);
                result.insert(startIndex, "(");
                result.append(")");
                break;
            }

            // Store remainder with its position in the result
            remainderMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        StringBuilder output = new StringBuilder();
        while (T-- > 0) {
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            output.append(fractionToDecimal(numerator, denominator)).append("\n");
        }
        scanner.close();

        // Print all results in one go for efficiency
        System.out.print(output);
    }
}

}

//REMAINDER = A MOD B = A
//SHIFT ONE PLACE TO LEFT TO MAKE IT A NUMBER, CURRENTLY IT'S REMAINDER
//NOW GET THE QUOTIENT
//NOW AGAIN DO THE REMAINDER PART AND IF REPEATING APPEARS BREAK.


/*remainder *= 10;

Simulates bringing down the next digit in long division.

Example: 2 → 20, 1 → 10, etc.

result.append(remainder / den);

Extracts the next decimal digit by performing integer division.

Example: 20 / 3 = 6, 10 / 3 = 3, etc.

remainder %= den;

Computes the remainder to check if a cycle exists.

Example: 20 % 3 = 2, 10 % 3 = 1, etc */
