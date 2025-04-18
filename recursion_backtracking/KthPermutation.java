package recursion_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int size = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        int[] elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i + 1;
        }

        boolean[] used = new boolean[size];
        int[] count = new int[]{0}; // to count permutations
        printKthPerm(elements, new ArrayList<>(), used, k, count);
    }

    public static void printKthPerm(int[] elements, List<Integer> currPerm, boolean[] used, int k, int[] count) {
        if (currPerm.size() == elements.length) {
            count[0]++;
            if (count[0] == k) {
                for (int num : currPerm) {
                    System.out.print(num + " ");
                }
                System.exit(0); // stop the program after printing k-th perm
            }
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            currPerm.add(elements[i]);
            printKthPerm(elements, currPerm, used, k, count);
            currPerm.remove(currPerm.size() - 1);
            used[i] = false;
        }
    }
}

}
