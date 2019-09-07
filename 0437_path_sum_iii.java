/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        // 3 parts: 1) sum from left subtree, 2) right subtree, 3) has to be from root;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + helper(root, sum); 
    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        
        if (sum == root.val) {
            result++;
        }
        
        result += helper(root.left, sum - root.val);
        result += helper(root.right, sum - root.val);
        return result;
    }
}