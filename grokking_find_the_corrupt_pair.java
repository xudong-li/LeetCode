class FindCorruptNums {

  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
  public static int[] findNumbers(int[] nums) {
    // TODO: Write your code here
    int start = 0;
    while (start < nums.length) {
      int index = nums[start] - 1;
      if (nums[start] != nums[index]) {
        swap(nums, start, index);
      }
      else {
        start++;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] - 1 != i) {
        return new int[] {nums[i], i + 1};
      }
    }
    return new int[] { -1, -1 };
  }
}
