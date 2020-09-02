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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // divide the problems into 3 subproblems (left, root, right)
        List<Integer> result = new ArrayList<>();
        
        //1. add left
        addLeft(root, result);
        
        //2. add leaf
        addLeaf(root, result);
        
        //3. add right
        addRight(root, result);
        return result;
    }
    
    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
    
    private void addLeft(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                result.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
    }
    
    private void addLeaf(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        addLeaf(root.left, result);
        addLeaf(root.right, result);
    }
    
    private void addRight(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        
        TreeNode node = root.right;
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}



