package binary_search;

import java.util.*;

public class MultiplicationTable{
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    long n = scn.nextLong();
    long low = 1;
    long high = (n * n);
    long ans = -1;
    long countQualifiedMedian = ((n * n) + 1) / 2;
    while(low <= high){
      long mid = low + (high - low)/2;
      if(possibleMedian(mid, countQualifiedMedian, n)){
        ans = mid;
        high = mid - 1;
      }else{
        low = mid + 1;
      }
    }
    System.out.println(ans);
  }

  public static boolean possibleMedian(long x, long countQualifiedMedian, long n){
    long countEleLessThanEqualX = 0;
    for(long i=1; i <= n; i++){
      countEleLessThanEqualX += Math.min(n, (x/i));
    }
    return countEleLessThanEqualX >= countQualifiedMedian;
  }
}
