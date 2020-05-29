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
    TreeNode treeNode;
    int column;
    public Node(TreeNode treeNode, int column) {
        this.treeNode = treeNode;
        this.column = column;
    }
}


class Solution {
    TreeMap<Integer, List<Integer>> columnTable = new TreeMap<>();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (!columnTable.containsKey(curr.column)) {
                columnTable.put(curr.column, new ArrayList<Integer>());
            } 
            columnTable.get(curr.column).add(curr.treeNode.val);
            
            if (curr.treeNode.left != null) {
                q.offer(new Node(curr.treeNode.left, curr.column - 1));
            }
            if (curr.treeNode.right != null) {
                q.offer(new Node(curr.treeNode.right, curr.column + 1));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry : columnTable.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
}


