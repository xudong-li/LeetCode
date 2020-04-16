class CeilingOfANumber {

  public static int searchCeilingOfANumber(int[] arr, int key) {
    // TODO: Write your code here
    int left = 0, right = arr.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == key) {
        return mid;
      } else if (arr[mid] < key) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (arr[left] >= key) {
      return left;
    }
    if (arr[right] >= key) {
      return right;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
  }
}