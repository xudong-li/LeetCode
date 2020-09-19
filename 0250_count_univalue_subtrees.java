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

class Node {
    int numOfSubtrees;
    int value;
    public Node (int numOfSubtrees, int value) {
        this.numOfSubtrees = numOfSubtrees;
        this.value = value;
    }
}
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root).numOfSubtrees;
    }
    
    private Node helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Node(1, node.val);
        }
        
        Node leftTree = null, rightTree = null;
        if (node.left != null) {
            leftTree = helper(node.left);
        }
        if (node.right != null) {
            rightTree = helper(node.right);
        }
        
        int left = leftTree == null ? 0 : leftTree.numOfSubtrees;
        int right = rightTree == null ? 0 : rightTree.numOfSubtrees;
        
        int numOfSubtrees = left + right;
        if (leftTree == null && rightTree != null && rightTree.value == node.val) {
            numOfSubtrees++;
        } else if (leftTree != null && rightTree == null && leftTree.value == node.val) {
            numOfSubtrees++;
        } else if (leftTree != null && rightTree != null && leftTree.value == node.val && rightTree.value == node.val) {
            numOfSubtrees++;
        } else {
            node.val = Integer.MAX_VALUE;
        }
        
        
        return new Node(numOfSubtrees, node.val);
    }
}