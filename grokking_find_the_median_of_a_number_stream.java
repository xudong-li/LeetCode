import java.util.*;

class MedianOfAStream {

  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap; 

  public MedianOfAStream(){
    minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
  }

  public void insertNum(int num) {
    // TODO: Write your code here
    if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (maxHeap.size() < minHeap.size()){
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian() {
    // TODO: Write your code here
    if (maxHeap.size() == minHeap.size()) {
      return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
    return maxHeap.peek();
  }

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}
