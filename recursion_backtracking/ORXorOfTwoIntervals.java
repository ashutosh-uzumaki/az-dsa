import java.util.*;

public class ORXorOfTwoIntervals{
  static long count = 0;
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = scn.nextInt();
    } 
    long[] min = new long[1];
    min[0] = Integer.MAX_VALUE;
    helper(0, 0, 0, min, arr);
    System.out.println(min[0]);
  }

  public static void helper(int idx, long setOne, long setTwo, long[] min, int[] arr){
    if(idx == arr.length){
      min[0] = Math.min(min[0], setOne ^ setTwo);
      return;
    }

    helper(idx + 1, setOne | arr[idx], setTwo, min, arr);
    helper(idx + 1, (setOne ^ setTwo), arr[idx], min, arr);
  }
}