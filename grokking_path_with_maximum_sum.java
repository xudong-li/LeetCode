class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class MaximumPathSum {
  private static int result = Integer.MIN_VALUE;
  public static int findMaximumPathSum(TreeNode root) {
    // TODO: Write your code here
    helper(root);
    return result;
  }

  private static int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = Math.max(helper(root.left), 0);
    int right = Math.max(helper(root.right), 0);

    int currSum = left + right + root.val;

    result = Math.max(result, currSum);

    return Math.max(left, right) + root.val;

  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root = new TreeNode(-1);
    root.left = new TreeNode(-3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
  }
}
