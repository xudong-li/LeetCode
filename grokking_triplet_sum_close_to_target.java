import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    // TODO: Write your code here
    Arrays.sort(arr);
    int smallestDiff = Integer.MAX_VALUE;
    int resultSum = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1;
      int right = arr.length - 1;
      while (left < right) {
        int diff = targetSum - arr[i] - arr[left] - arr[right];
        if (Math.abs(diff) < Math.abs(smallestDiff) 
              || Math.abs(diff) == Math.abs(smallestDiff) && arr[i] + arr[left] + arr[right] < resultSum) {
          smallestDiff = diff;
          resultSum = arr[i] + arr[left] + arr[right];
        }

        if (arr[i] + arr[left] + arr[right] < targetSum) {
          left++;
        } else {
          right--;
        }
      }
    }
    return resultSum;
  }
}