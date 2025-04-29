package matrix;

import java.util.Scanner;

public class PlaceStableRookies {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (k > (n + 1) / 2) {
                System.out.println("-1"); // Not possible to place k stable rooks
            } else {
                int[][] board = new int[n][n];
                int count = 0;
                
                for (int i = 0; i < n && count < k; i += 2) {
                    board[i][i] = 1; // Place rook at (i, i) //skipping adjacent diagonal
                    count++;
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[i][j] == 1 ? 'R' : '.');
                    }
                    System.out.println();
                }
            }
        }
    }
}

