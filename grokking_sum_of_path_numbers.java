import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class SumOfPathNumbers {
  private static int sum = 0;
  public static int findSumOfPathNumbers(TreeNode root) {
    // TODO: Write your code here
    int currSum = 0;
    helper(root, currSum);
    return sum;
  }

  private static void helper(TreeNode node, int currSum) {
    if (node == null) {
      return;
    }
    currSum = currSum * 10 + node.val;
    if (node.left == null && node.right == null) {
      sum += currSum;
    } else {
      helper(node.left, currSum);
      helper(node.right, currSum);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}
