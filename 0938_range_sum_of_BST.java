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
    public int rangeSumBST(TreeNode root, int L, int R) {      
        if (root == null) {
            return 0;
        }
              
        int leftSum = 0;
        int rightSum = 0;
        int currNode = 0;
        
        if (root.val >= L && root.val <= R) {
            currNode = root.val;
        } else {
            currNode = 0;
        }
        
        if (root.val > L) {
            leftSum = rangeSumBST(root.left, L, R);
        }
        
        if (root.val < R) {
            rightSum = rangeSumBST(root.right, L, R);
        } 
        
        return leftSum + rightSum + currNode;
    }
}