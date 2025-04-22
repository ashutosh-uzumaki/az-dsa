package number_theory;

import java.util.*;
import java.io.*;

public class MaxEvenSum{
  public static void main(String[] args)throws IOException{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(reader.readLine());
      int[] arr = new int[n];
      String[] tokens = reader.readLine().split(" ");
      int i = 0;
      for(String token: tokens){
        arr[i++] = Integer.parseInt(token);
      }
      Arrays.sort(arr);
      List<Integer> odds = new ArrayList<>();
      List<Integer> evens = new ArrayList<>();

      for(i=0; i<n; i++){
        if(arr[i] % 2 == 1){
          odds.add(arr[i]);
        }else{
          evens.add(arr[i]);
        }
      }
      int oddSum = 0, evenSum = 0;
      if(odds.size() >= 2){
        int a = odds.get(odds.size() - 1);
        int b = odds.get(odds.size() - 2);
        oddSum = a + b;
      }
      if(evens.size() >= 2){
        int a = evens.get(evens.size() - 1);
        int b = evens.get(evens.size() - 2);
        evenSum = a + b;
      }
      int maxSum = Math.max(oddSum, evenSum);
      if(maxSum == 0){
        System.out.println(-1);
      }else{
        System.out.println(maxSum);
      }
  }
}
