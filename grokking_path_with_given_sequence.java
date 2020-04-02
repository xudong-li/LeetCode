import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    // TODO: Write your code here
    int index = 0;
    return helper(root, sequence, index);
  }

  private static boolean helper(TreeNode root, int[] sequence, int index) {
    if (root == null) {
      return false;
    }
    if (index >= sequence.length || sequence[index] != root.val) {
      return false;
    };

    // if the current node is a leaf, and the index is the last, we have found a path!
    if (root.left == null && root.right == null && index == sequence.length - 1) {
      return true;
    }

    boolean left = helper(root.left, sequence, index + 1);
    boolean right = helper(root.right, sequence, index + 1);

    return left || right;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
