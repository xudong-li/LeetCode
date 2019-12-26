import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    // TODO: Write your code here
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      searchPairs(arr, i + 1, -arr[i], triplets);
    }
    return triplets;
  }

  private static void searchPairs(int[] arr, int left, int target, List<List<Integer>> triplets) {
    int right = arr.length - 1;
    while (left < right) {
      if (arr[left] + arr[right] == target) {
        List<Integer> triplet = new ArrayList<>();
        triplet.add(-target);
        triplet.add(arr[left]);
        triplet.add(arr[right]);
        triplets.add(triplet);
        left++;
        right--;

        while (left < right && arr[left] == arr[left - 1]) {
        left++;
        }
        while (left < right && arr[right] == arr[right + 1]) {
          right--;
        }
      } else if (arr[left] + arr[right] < target) {
        left++;
      } else {
        right--;
      }
    }
  }
}