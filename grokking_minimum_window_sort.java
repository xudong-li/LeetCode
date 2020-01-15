class ShortestWindowSort {

  public static int sort(int[] arr) {
    // TODO: Write your code here
    int left = 0, right = arr.length - 1;
    // find the first number that breaks the sorting from left
    while (left < arr.length - 1 && arr[left] <= arr[left + 1]) {
      left++;
    }

    // array is sorted
    if (left == arr.length - 1) {
      return 0;
    }

    //find the last number that breaks sorting from right
    while (right > 0 && arr[right] >= arr[right - 1]) {
      right--;
    }

    int subarrayMin = Integer.MAX_VALUE, subarrayMax = Integer.MIN_VALUE;
    for (int i = left; i <= right; i++) {
      subarrayMin = Math.min(subarrayMin, arr[i]);
      subarrayMax = Math.max(subarrayMax, arr[i]);
    }

    while (left > 0 && arr[left - 1] > subarrayMin) {
      left--;
    }

    while (right < arr.length - 1 && arr[right + 1] < subarrayMax) {
      right++;
    }

    return right - left + 1;
  }
}