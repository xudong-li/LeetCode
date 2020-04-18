class MaxInBitonicArray {

  public static int findMax(int[] arr) {
    // TODO: Write your code here
    int left = 0, right = arr.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > arr[mid - 1]) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (arr[left] > arr[right]) {
      return arr[left];
    }
    return arr[right];
  }

  public static void main(String[] args) {
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
  }
}