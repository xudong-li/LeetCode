class BinarySearch {

  public static int search(int[] arr, int key) {
    // TODO: Write your code here
    int left = 0, right = arr.length - 1;
    boolean isIncreasingOrder = arr[left] < arr[right];
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == key) {
        return mid;
      }
      if (isIncreasingOrder) {
        if (arr[mid] < key) {
          left = mid;
        } else {
          right = mid;
        }
      } else {
        if (arr[mid] < key) {
          right = mid;
        } else {
          left = mid;
        }
      }
    }

    if (arr[left] == key) {
      return left;
    }

    if (arr[right] == key) {
      return right;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
  }
}