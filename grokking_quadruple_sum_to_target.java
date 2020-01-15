import java.util.*;

class QuadrupleSumToTarget {

  public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
    List<List<Integer>> quadruplets = new ArrayList<>();
    // TODO: Write your code here
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 3; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) continue;
      for (int j = i + 1; j < arr.length - 2; j++) {
        if (j > 0 && arr[j] == arr[j - 1]) continue;
        searchPairs(arr, target, i, j, quadruplets);
      }
    }
    return quadruplets;
  }

  private static void searchPairs(int[] arr, int target, int first, int second, List<List<Integer>> quadruplets) {
    int left = second + 1, right = arr.length - 1;
    while (left < right) {
      int sum = arr[first] + arr[second] + arr[left] + arr[right];
      if (sum == target) {
        List<Integer> result = new ArrayList<>();
        result.add(arr[first]);
        result.add(arr[second]);
        result.add(arr[left]);
        result.add(arr[right]);
        quadruplets.add(result);

        left++;
        right--;
        while (left < right && arr[left] == arr[left - 1]) {
          left++;
        }
        while (left < right && arr[right] == arr[right + 1]) {
          right--;
        }
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
  }
}