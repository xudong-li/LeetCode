/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class ReturnType{
    boolean isBalanced;
    int height;
    
    public ReturnType(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
};

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root).isBalanced;
    }
    
    public ReturnType helper(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        
        if (!left.isBalanced || !right.isBalanced) {
            return new ReturnType(false, -1);
        }
        
        if (Math.abs(left.height - right.height) > 1) {
            return new ReturnType(false, -1);
        }
        
        return new ReturnType(true, Math.max(left.height, right.height) + 1);
    }
}