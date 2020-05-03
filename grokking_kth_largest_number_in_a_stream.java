import java.util.*;

class KthLargestNumberInStream {
  private PriorityQueue<Integer> minHeap;
  private final int k;
  public KthLargestNumberInStream(int[] nums, int k) {
    // TODO: Write your code here
    minHeap = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);
    this.k = k;

    for (int num : nums) {
      add(num);
    }
  }

  public int add(int num) {
    // TODO: Write your code here
    minHeap.add(num);

    if (minHeap.size() > k) {
      minHeap.poll();
    }

    return minHeap.peek();

  }

  public static void main(String[] args) {
    int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
    KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
    System.out.println("4th largest number is: " + kthLargestNumber.add(6));
    System.out.println("4th largest number is: " + kthLargestNumber.add(13));
    System.out.println("4th largest number is: " + kthLargestNumber.add(4));
  }
}