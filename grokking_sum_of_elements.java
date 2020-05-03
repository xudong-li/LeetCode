import java.util.*;

class SumOfElements {

  public static int findSumOfElements(int[] nums, int k1, int k2) {
    // TODO: Write your code here
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i1, i2)  -> i1 - i2);
    for (int num : nums) {
      minHeap.add(num);
    }

    int count = 1;
    int sum = 0;
    while (!minHeap.isEmpty()) {
      int temp = minHeap.poll();
      if (count > k1 && count < k2) {
        sum += temp;
      }
      count++;
    }
    return sum;
  }

  public static void main(String[] args) {
    int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
  }
}
