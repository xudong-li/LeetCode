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
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> curr) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null && root.val == sum) {
            curr.add(root.val);
            result.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        
        curr.add(root.val);
        helper(root.left, sum - root.val, curr);
        helper(root.right, sum - root.val, curr);
        curr.remove(curr.size() - 1);
        
        return;
    }
}