package number_theory;

import java.util.*;
import java.io.*;

public class PairsDivisibleByFive {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        long m = Long.parseLong(tokens[0]);
        long n = Long.parseLong(tokens[1]);

        long[] x = new long[5];
        long[] y = new long[5];

        for(long i=1; i<=m; i++){
            x[(int)(i%5)]++;
        }
        for(int i=1; i<=n; i++){
            y[(int)(i%5)]++;
        }
        long count = 0;
        for(int i=0; i<=4; i++){
            if(i == 0){
                count += (x[0] * y[0]);
                continue;
            }
            count += (x[i] * y[5-i]);
        }
        System.out.println(count);
    }
}

