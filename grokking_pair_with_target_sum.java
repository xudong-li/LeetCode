class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    // TODO: Write your code here
    int left = 0, right = arr.length - 1;
    while (left < right) {
      if (arr[left] + arr[right] == targetSum) {
        return new int[] {left, right};
      } else if (arr[left] + arr[right] < targetSum) {
        left++;
      } else {
        right--;
      }
    }
    return new int[] { -1, -1 };
  }
}