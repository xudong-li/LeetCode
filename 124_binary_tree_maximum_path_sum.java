/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class resultType {
    int singlePath;
    int maxPath;
    
    public resultType(int singlePath, int maxPath) {
        this.singlePath = singlePath;
        this.maxPath = maxPath;
    }
};

class Solution {
    public int maxPathSum(TreeNode root) {
        resultType result = helper(root);
        return result.maxPath;
    }
    
    private resultType helper(TreeNode root) {
        if (root == null) {
            return new resultType(0, Integer.MIN_VALUE);
        }
        
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        
        return new resultType(singlePath, maxPath);
    }
}