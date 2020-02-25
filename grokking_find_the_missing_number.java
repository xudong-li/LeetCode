class MissingNumber {
  
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  public static int findMissingNumber(int[] nums) {
    // TODO: Write your code here
    int start = 0;
    while (start < nums.length) {
      int index = nums[start];
      if (index < nums.length && index != nums[index]) {
        swap(nums, start, index);
      } else {
        start++;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return nums.length;
  }
}
