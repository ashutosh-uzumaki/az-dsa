package matrix;
import java.util.*;
import java.io.*;

public class MatrixPrefixSum {
    public static void main(String[] args) throws IOException {
        int[][] mat = new int[5][6];
        Random rand = new Random();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = rand.nextInt(100) + 1; // Random number from 1 to 100
            }
        }

        int[][] prefixSum = new int[5][6];

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                prefixSum[i][j] = mat[i][j];
                if(i > 0) prefixSum[i][j] += mat[i-1][j];
                if(j > 0) prefixSum[i][j] += mat[i][j-1];
                if(i > 0 && j > 0) prefixSum[i][j] -= mat[i-1][j-1];
            }
        }

        int[][] queries = {
            {0, 1, 2, 4},
            {1, 0, 3, 3},
            {2, 2, 4, 5},
            {0, 0, 1, 2},
            {3, 1, 4, 4}
        };

        int idx = 0;
        while (idx < queries.length) {
            int r1 = queries[idx][0];
            int c1 = queries[idx][1];
            int r2 = queries[idx][2];
            int c2 = queries[idx][3];

            int ans = prefixSum[r2][c2];
            if(c1 > 0) ans -= prefixSum[r2][c1 - 1];
            if(r1 > 0) ans -= prefixSum[r1 - 1][c2];
            if(r1 > 0 && c1 > 0) ans += prefixSum[r1-1][c1-1];

            System.out.println(ans);
            idx++;
        }
    }
}

