import java.util.*;

class KLargestNumbers {

  public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    // TODO: Write your code here
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
    for(int i = 0; i < k; i++) {
      minHeap.add(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (minHeap.peek() < nums[i]) {
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }
    return new ArrayList<>(minHeap);
  }

  public static void main(String[] args) {
    List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
    System.out.println("Here are the top K numbers: " + result);

    result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Here are the top K numbers: " + result);
  }
}
