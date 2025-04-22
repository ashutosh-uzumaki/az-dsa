package number_theory;

import java.util.*;
import java.io.*;

public class KFactorization {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        List<Integer> factors = getFactors(n);

        if(factors.size() < k){
            System.out.println(-1);
        }else{
            List<Integer> result = new ArrayList<>();
            int idx = 0;
            while(result.size() < k - 1){
                result.add(factors.get(idx));
                idx++;
            }

            int last = 1;
            while(idx < factors.size()){
                last *= factors.get(idx);
                idx++;
            }

            for(int i=0; i<result.size(); i++){
                System.out.print(result.get(i)+" ");
            }
            System.out.println(last);
        }


    }

    public static List<Integer> getFactors(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i=2; i*i<=n; i++){
            while(n % i == 0){
                factors.add(i);
                n /= i;
            }
        }

        if(n > 1){
            factors.add(n);
        }

        return factors;
    }
}

