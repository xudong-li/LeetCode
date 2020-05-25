/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/** 
* We can leverage the property of BST that the left subtree of a node is less than that node
* to make the seralization as compact as possible 
*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        return sb.toString();
    }
    
    private void rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(String.valueOf(root.val)).append(",");
        rserialize(root.left, sb);
        rserialize(root.right, sb);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        
        String[] dataArray = data.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode rdeserialize(Queue<String> q, int lowerBound, int upperBound) {
        if (q.isEmpty()) {
            return null;
        }
        
        String curr = q.peek();
        if (Integer.valueOf(curr) < lowerBound || Integer.valueOf(curr) > upperBound) {
            return null;
        }
        
        curr = q.poll();
        
        TreeNode root = new TreeNode(Integer.valueOf(curr));
        root.left = rdeserialize(q, lowerBound, Integer.valueOf(curr));
        root.right = rdeserialize(q, Integer.valueOf(curr), upperBound);
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));