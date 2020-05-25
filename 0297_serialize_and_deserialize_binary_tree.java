/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = rserialize(root, new StringBuilder());
        return result.toString();
    }
    
    private StringBuilder rserialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
        } else {
            str.append(String.valueOf(root.val) + ",");
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(q);
    }
    
    private TreeNode rdeserialize(Queue<String> q) {
        String curr = q.poll();
        if (curr.equals("null")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(curr));
        root.left = rdeserialize(q);
        root.right = rdeserialize(q);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));