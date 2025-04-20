package number_theory;

import java.util.*;
import java.io.*;

public class CountSwappables{
  public static void main(String[] args)throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(reader.readLine());
    String[] tokens = reader.readLine().split(" ");
    long[] arr = new long[size];
    int idx = 0;
    for(String token: tokens){
    	arr[idx++] = Long.parseLong(token);
    }

    long totalPairs = getCombinations(size);
    Map<Long, Long> freq = new HashMap<>();
    for(int i=0; i<size; i++){
    	if(freq.containsKey(arr[i])){
    		long val = freq.get(arr[i]) + 1;
    		freq.put(arr[i], val);
    	}else{
    		freq.put(arr[i], 1L);
    	}
    }
    long invalid = 0;
    for(Map.Entry<Long, Long> pair: freq.entrySet()){
    	long val = pair.getValue();
    	invalid += getCombinations(val);
    }

    System.out.println(totalPairs - invalid);

  }

  public static long getCombinations(long n){
  	return n * (n - 1) / 2;
  }
}
