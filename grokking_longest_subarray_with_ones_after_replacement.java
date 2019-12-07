class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    // TODO: Write your code here
    int[] numCount = new int[2];
    int oneCount = 0;
    int windowStart = 0;
    int result = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      int rightNum = arr[windowEnd];
      numCount[rightNum]++;
      if (rightNum == 1) {
        oneCount++;
      }

      if (windowEnd - windowStart + 1 - oneCount > k) {
        int leftNum = arr[windowStart];
        numCount[leftNum]--;
        if (leftNum == 1) {
          oneCount--;
        }
        windowStart++;
      }

      result = Math.max(result, windowEnd - windowStart + 1);
    }
    return result;
  }
}
