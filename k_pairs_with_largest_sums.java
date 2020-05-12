import java.util.*;

class Node {
  int l1Index;
  int l2Index;
  public Node (int l1Index, int l2Index) {
    this.l1Index = l1Index;
    this.l2Index = l2Index;
  }
}

class LargestPairs {

  public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
    List<int[]> result = new ArrayList<>();
    // TODO: Write your code here    
    PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1,n2) 
      -> (nums1[n1.l1Index] + nums2[n1.l2Index]) - (nums1[n2.l1Index] + nums2[n2.l2Index]));

    int count = 0;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        if (count < k) {
          minHeap.add(new Node(i, j));
          count++;
        } else {
          if (nums1[i] + nums2[j] > nums1[minHeap.peek().l1Index] + nums2[minHeap.peek().l2Index]) {
            minHeap.poll();
            minHeap.add(new Node (i, j));
          }
        }
      }
    }

    while (!minHeap.isEmpty()) {
      Node curr = minHeap.poll();
      result.add(new int[]{nums1[curr.l1Index], nums2[curr.l2Index]});
    }  
    // Runtime: O(m*nlogk)
    return result;
  }

  public static void main(String[] args) {
    int[] l1 = new int[] { 9, 8, 2 };
    int[] l2 = new int[] { 6, 3, 1 };
    List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
    System.out.print("Pairs with largest sum are: ");
    for (int[] pair : result)
      System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
  }
}
