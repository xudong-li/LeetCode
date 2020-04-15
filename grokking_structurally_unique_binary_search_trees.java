import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class UniqueTrees {
  public static List<TreeNode> findUniqueTrees(int n) {
    List<TreeNode> result = new ArrayList<>();
    // TODO: Write your code here
    result = helper(1, n);
    return result;
  }

  private static List<TreeNode> helper(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftNodes = helper(start, i - 1);
      List<TreeNode> rightNodes = helper(i + 1, end);
      for (TreeNode leftNode : leftNodes) {
        for (TreeNode rightNode : rightNodes) {
          TreeNode curr = new TreeNode(i);
          curr.left = leftNode;
          curr.right = rightNode;
          result.add(curr);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<TreeNode> result = UniqueTrees.findUniqueTrees(3);
    System.out.print("Total trees: " + result.size());
  }
}
