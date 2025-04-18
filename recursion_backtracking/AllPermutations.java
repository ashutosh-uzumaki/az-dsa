package recursion_backtracking;

import java.io.*;
import java.util.*;

public class AllPermutations {

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        String[] tokens = reader.readLine().split(" ");
        int[] elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(elements); // Important for duplicate check
        boolean[] used = new boolean[size];
        printAllPermutations(elements, new ArrayList<>(), used);
    }

    public static void printAllPermutations(int[] elements, List<Integer> currPerm, boolean[] used) {
        if (currPerm.size() == elements.length) {
            for (int num : currPerm) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (used[i]) continue;

            if (i > 0 && elements[i] == elements[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            currPerm.add(elements[i]);
            printAllPermutations(elements, currPerm, used);
            currPerm.remove(currPerm.size() - 1);
            used[i] = false;
        }
    }
}

}
