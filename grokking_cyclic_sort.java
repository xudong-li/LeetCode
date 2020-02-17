class CyclicSort {


  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void sort(int[] nums) {
    // TODO: Write your code here
    int start = 0;
    while (start < nums.length) {
      int index = nums[start] - 1;
      if (nums[index] != nums[start]) {
        swap(nums, index, start);
      } else {
        start++;
      }
    }
  }
}
