import java.util.*;

class SlidingWindowMedian {
  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap;

  public SlidingWindowMedian() {
    minHeap = new PriorityQueue<Integer> ((a, b) -> a - b);
    maxHeap = new PriorityQueue<Integer> ((a, b) -> b - a);
  }

  private void rebalanceHeaps() {
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  public double[] findSlidingWindowMedian(int[] nums, int k) {
    double[] result = new double[nums.length - k + 1];
    // TODO: Write your code here
    for (int i = 0; i < nums.length; i++) {
      if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
        maxHeap.add(nums[i]);
      } else {
        minHeap.add(nums[i]);
      }
      rebalanceHeaps();

      if (i - k + 1 >= 0) {
        if (minHeap.size() == maxHeap.size()) {
          result[i - k + 1] = (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
          result[i - k + 1] = (double) (maxHeap.peek());
        }
        //remove elements
        int elementToBeRemoved = nums[i - k + 1];
        if (elementToBeRemoved <= maxHeap.peek()) {
          maxHeap.remove(elementToBeRemoved);
        } else {
          minHeap.remove(elementToBeRemoved);
        }
        rebalanceHeaps();
      }
    }

    return result;
  }

  public static void main(String[] args) {
    SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
    double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
    System.out.println();

    slidingWindowMedian = new SlidingWindowMedian();
    result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
  }

}