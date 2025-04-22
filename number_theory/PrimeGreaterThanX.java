package number_theory;

import java.util.*;
import java.io.*;

public class PrimeGreaterThanX{
  public static void main(String[] args)throws IOException{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	int x = Integer.parseInt(reader.readLine());
      boolean[] primes = new boolean[(int)1e6+1];
      Arrays.fill(primes, true);
      primes[0] = false;
      primes[1] = false;

      for(int i=2; i<=primes.length; i++){
        if(primes[i] == true){
          for(int j=2*i; j<=primes.length; j+=i){
            primes[j] = false;
          }
        }
      }

      for(int i=x; i<=primes.length; i++){
        if(primes[x] == true){
          System.out.println(i);
        }
      }

  }
}
