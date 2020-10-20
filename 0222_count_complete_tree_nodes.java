/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public int countNodes(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
        
//         int left = countNodes(root.left);
//         int right = countNodes(root.right);
        
//         return left + right + 1;
//     }
// }

class Solution {
    private int countDepth(TreeNode node) {
        int depth = 0;
        while (node.left != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
    
    private boolean exists(int idx, int depth, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, depth) - 1;
        int pivot;
        for(int i = 0; i < depth; ++i) {
          pivot = left + (right - left) / 2;
          if (idx <= pivot) {
            node = node.left;
            right = pivot;
          }
          else {
            node = node.right;
            left = pivot + 1;
          }
        }
        return node != null;
    }
    public int countNodes(TreeNode root) {
    // if the tree is empty
    if (root == null) return 0;

    int d = countDepth(root);
    // if the tree contains 1 node
    if (d == 0) return 1;

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Perform binary search to check how many nodes exist.
    int left = 1, right = (int)Math.pow(2, d) - 1;
    int pivot;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (exists(pivot, d, root)) left = pivot + 1;
      else right = pivot - 1;
    }

    // The tree contains 2**d - 1 nodes on the first (d - 1) levels
    // and left nodes on the last level.
    return (int)Math.pow(2, d) - 1 + left;
  }
}