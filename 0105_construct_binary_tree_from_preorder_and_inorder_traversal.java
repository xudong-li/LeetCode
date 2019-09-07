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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, 
                            int[] inorder, int inStart, int inEnd){
        
        if (inStart > inEnd) {
            return null;
        }
        
        //the first element in preorder is the root
        TreeNode root = new TreeNode(preorder[preStart]);
        
        //find the root in inorder array
        int position = findPosition(inorder, inStart, inEnd, preorder[preStart]);
        
        //the left subtree is left to the root of the inorder array
        root.left = helper(preorder, preStart + 1, preStart + position - inStart,
                          inorder, inStart, position - 1);
        
        //the right subtree is right to the root of the inorder array
        root.right = helper(preorder, position - inEnd + preEnd + 1, preEnd,
                           inorder, position + 1, inEnd);
        
        return root;
    }
    
    private int findPosition(int[] inorder, int inStart, int inEnd, int key) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}