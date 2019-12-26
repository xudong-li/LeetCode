import java.util.*;

class TripletWithSmallerSum {

  public static int searchTriplets(int[] arr, int target) {
    int count = 0;
    // TODO: Write your code here
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1, right = arr.length - 1;
      while (left < right) {
        int sum = arr[i] + arr[left] + arr[right];
        if (sum < target) {
          count += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    return count;
  }
}