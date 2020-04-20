class SearchRotatedArray {

  public static int search(int[] arr, int key) {
    // TODO: Write your code here
    int start = 0, end = arr.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == key) {
        return mid;
      } else if (arr[mid] > arr[start]) {
        if (arr[start] <= key && arr[mid] >= key) {
          end = mid;
        } else {
          start = mid;
        }
      } else {
        if (arr[end] >= key && arr[mid] <= key) {
          start = mid;
        } else {
          end = mid;
        }
      }
    }
    if (arr[start] == key) {
      return start;
    }
    if (arr[end] == key) {
      return end;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
    System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
  }
}
