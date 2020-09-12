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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private int helper(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return -1;
        }
        int level = 1 + Math.max(helper(node.left, result), helper(node.right, result));
        if (level == result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);
        
        return level;
    }
}