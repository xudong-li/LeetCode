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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        List<String> result = new ArrayList<String>();
        
        for (String s : left) {
            String temp = root.val + "->" + s;
            result.add(temp);
        }
        
        for (String s: right) {
            String temp = root.val + "->" + s;
            result.add(temp);
        }
        
        if (result.size() == 0) {
            result.add("" + root.val);
        }
        
        return result;
    }
}