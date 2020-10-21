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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    
    private int helper(TreeNode node, boolean isLeft) {
        
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null) {
            if (isLeft) {
                return node.val;
            }
            return 0;
        }
        
        int left = helper(node.left, true);
        int right = helper(node.right, false);
        
        return left + right;
    }
}