import java.util.*;

class Node {
  int x;
  int y;
  public Node (int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class KthSmallestInSortedMatrix {

  public static int findKthSmallest(int[][] matrix, int k) {
    // TODO: Write your code here
    PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1,n2) 
      -> matrix[n1.x][n1.y] - matrix[n2.x][n2.y]);

    for (int i = 0; i < matrix.length; i++) {
      minHeap.add(new Node(i,0));
    }

    int count = 0;
    while (!minHeap.isEmpty()) {
      Node temp = minHeap.poll();
      count++;
      if (count == k) {
        return matrix[temp.x][temp.y];
      }
      if (temp.y < matrix[0].length - 1) {
        minHeap.add(new Node(temp.x, temp.y + 1));
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
    int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}
