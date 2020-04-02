import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    // TODO: Write your code here
    List<Integer> currPath = new ArrayList<>();
    helper(root, sum, currPath, allPaths);    
    return allPaths;
  }

  private static void helper(TreeNode node, int sum, List<Integer> currPath, List<List<Integer>> allPaths) {
    if (node == null) {
      return;
    }
    currPath.add(node.val);
    if (node.left == null && node.right == null && node.val == sum) {
      allPaths.add(new ArrayList<Integer>(currPath));
    } else {
      helper(node.left, sum - node.val, currPath, allPaths);
      helper(node.right, sum - node.val, currPath, allPaths);
    }
    currPath.remove(currPath.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}
