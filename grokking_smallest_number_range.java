import java.util.*;

class Node {
  int arrayIndex;
  int elementIndex;
  public Node (int arrayIndex, int elementIndex) {
    this.arrayIndex = arrayIndex;
    this.elementIndex = elementIndex;
  }
}

class SmallestRange {

  public static int[] findSmallestRange(List<Integer[]> lists) {
    // TODO: Write your code here
    PriorityQueue<Node> minHeap = new PriorityQueue<Node> ((n1,n2)
      -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

    int start = 0, end = Integer.MAX_VALUE, currMaxNumber = Integer.MIN_VALUE;
    for (int i = 0; i < lists.size(); i++) {
      minHeap.add(new Node(i, 0));
      currMaxNumber = Math.max(currMaxNumber, lists.get(i)[0]);
    }

    while (minHeap.size() == lists.size()) {
      Node curr = minHeap.poll();
      if (end - start > currMaxNumber - lists.get(curr.arrayIndex)[curr.elementIndex]) {
        start = lists.get(curr.arrayIndex)[curr.elementIndex];
        end = currMaxNumber;
      }
      if (curr.elementIndex < lists.get(curr.arrayIndex).length - 1) {
        minHeap.add(new Node(curr.arrayIndex, curr.elementIndex + 1));
        currMaxNumber = Math.max(currMaxNumber, lists.get(curr.arrayIndex)[curr.elementIndex + 1]);
      }
    } 
    return new int[] {start, end};
  }

  public static void main(String[] args) {
    Integer[] l1 = new Integer[] { 1, 5, 8 };
    Integer[] l2 = new Integer[] { 4, 12 };
    Integer[] l3 = new Integer[] { 7, 8, 10 };
    List<Integer[]> lists = new ArrayList<Integer[]>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int[] result = SmallestRange.findSmallestRange(lists);
    System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
  }
}
