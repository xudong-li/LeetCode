import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class CountAllPathSum {
  private static int count = 0;
  public static int countPaths(TreeNode root, int S) {
    // TODO: Write your code here
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    helper(root, S, 0, currPath, result);
    return result.size();
  }
  
  private static void helper(TreeNode root, int sum, int level, List<Integer> currPath, List<List<Integer>> result) {
    if (root == null) {
      return;
    }
    int temp = sum;
    currPath.add(root.val);
    for (int i = level; i >= 0; i--) {
      temp -= currPath.get(i);
      if (temp == 0) {
        List<Integer> oneSolution = new ArrayList<>();
        for (int j = i; j <= level; j++) {
          oneSolution.add(currPath.get(i));
        }
        result.add(new ArrayList<>(oneSolution));
      }
    }

    helper(root.left, sum, level + 1, currPath, result);
    helper(root.right, sum, level + 1, currPath, result);

    currPath.remove(currPath.size() - 1);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
  }
}
