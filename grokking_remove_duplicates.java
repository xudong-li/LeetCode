class RemoveDuplicates {

  public static int remove(int[] arr) {
    // TODO: Write your code here
    int nextNonDuplicate = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        nextNonDuplicate++;
      }
    }
    return nextNonDuplicate;
  }
}
