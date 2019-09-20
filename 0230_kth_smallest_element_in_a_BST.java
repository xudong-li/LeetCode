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
    private List<Integer> traverse = new ArrayList<Integer>(); 
    
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        return traverse.get(k - 1);
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        traverse.add(root.val);
        helper(root.right);
    }
}