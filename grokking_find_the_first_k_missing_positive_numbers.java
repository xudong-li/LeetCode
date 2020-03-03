import java.util.*;

class FirstKMissingPositive {

  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
  public static List<Integer> findNumbers(int[] nums, int k) {
    List<Integer> missingNumbers = new ArrayList<>();
    // TODO: Write your code here
    int start = 0;
    while (start < nums.length) {
      int index = nums[start] - 1;
      if (nums[start] > 0 && nums[start] <= nums.length && nums[start] != nums[index]) {
        swap(nums, start, index);
      } else {
        start++;
      }
    }

    Set<Integer> extraNumbers = new HashSet<>();

    for (int i = 0; i < nums.length && missingNumbers.size() < k; i++) {
      if (nums[i] - 1 != i) {
        missingNumbers.add(i + 1);
        extraNumbers.add(nums[i]);
      }
    }

    for (int i = 1; missingNumbers.size() < k; i++) {
      int candidate = i + nums.length;
      if (!extraNumbers.contains(candidate)) {
        missingNumbers.add(candidate);
      }
    }

    return missingNumbers;
  }
}