import java.util.*;

class AllMissingNumbers {

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();
    // TODO: Write your code here
    int start = 0;
    while (start < nums.length) {
      int index = nums[start] - 1;
      if (nums[start] != nums[index]) {
        swap(nums, index, start);
      } else {
        start++;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        missingNumbers.add(i + 1);
      }
    }

    return missingNumbers;
  }
}
