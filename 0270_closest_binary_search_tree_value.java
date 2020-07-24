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
    public int closestValue(TreeNode root, double target) {
        TreeNode next = target < root.val ? root.left : root.right;
        if (next == null) {
            return root.val;
        }
        int nextValue = closestValue(next, target);
        
        return Math.abs(root.val - target) < Math.abs(nextValue - target) ? root.val : nextValue;
    }
    
}