class FindDuplicate {

  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
  public static int findNumber(int[] nums) {
    // TODO: Write your code here
    int start = 0;
    while (start < nums.length) {
      if (nums[start] != start + 1) {
        int index = nums[start] - 1;
        if (nums[start] != nums[index]) {
          swap(nums, start, index);
        } else {
          return nums[start];
        }
      } else {
        start++;
      }
    }
    
    return -1;
  }
}
