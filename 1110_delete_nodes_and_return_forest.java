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
    List<TreeNode> result;
    Set<Integer> to_delete_set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        to_delete_set = new HashSet<>();
        for (int i : to_delete) {
            to_delete_set.add(i);
        }
        if (!to_delete_set.contains(root.val)) result.add(root);
        helper(root);
        return result;
    }
    
    private TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        node.left = helper(node.left);
        node.right = helper(node.right);
        
        if (to_delete_set.contains(node.val)) {
            if (node.left != null) result.add(node.left);
            if (node.right != null) result.add(node.right);
            return null;
        }
        return node;
    }
}