class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here
    int result = Integer.MIN_VALUE;
    int sum = 0;
    int start = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (i >= k - 1) {
        result = Math.max(result, sum);
        sum -= arr[start];
        start++;
      }
    }
    return result;
  }
}