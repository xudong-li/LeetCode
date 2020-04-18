class MinimumDifference {

  public static int searchMinDiffElement(int[] arr, int key) {
    // TODO: Write your code here
    int left = 0, right = arr.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] <= key) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (Math.abs(arr[left] - key) < Math.abs(arr[right] - key)) {
      return arr[left];
    }
    return arr[right];
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}