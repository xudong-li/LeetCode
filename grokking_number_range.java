class FindRange {

  public static int[] findRange(int[] arr, int key) {
    int[] result = new int[] { -1, -1 };
    // TODO: Write your code here
    result[0] = helper1(arr, key);
    result[1] = helper2(arr, key);
    return result;
  }

  private static int helper1(int[] arr, int key) {
    int left = 0, right = arr.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < key) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (arr[right] == key) {
      return right;
    }
    return -1;
  }

  private static int helper2(int[] arr, int key) {
    int left = 0, right = arr.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > key) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (arr[left] == key) {
      return left;
    }
    return -1;
  }  


  public static void main(String[] args) {
    int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
  }
}