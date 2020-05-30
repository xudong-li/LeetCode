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
    int row;
    public Node(TreeNode treeNode, int column, int row) {
        this.treeNode = treeNode;
        this.column = column;
        this.row = row;
    }
}


class NodeComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
        if (n1.column == n2.column) {
            if (n1.row == n2.row) {
                return n1.treeNode.val - n2.treeNode.val;
            } else {
                return n1.row - n2.row;
            }
        } else {
            return n1.column - n2.column;
        }
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        
        TreeMap<Integer, PriorityQueue<Node>> columnTable = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0, 0));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (!columnTable.containsKey(curr.column)) {
                columnTable.put(curr.column, new PriorityQueue<Node>(new NodeComparator()));
            }
            columnTable.get(curr.column).add(curr);
            
            if (curr.treeNode.left != null) {
                q.offer(new Node(curr.treeNode.left, curr.column - 1, curr.row + 1));
            }
            
            if (curr.treeNode.right != null) {
                q.offer(new Node(curr.treeNode.right, curr.column + 1, curr.row + 1));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Node>> entry : columnTable.entrySet()) {
            List<Integer> currList = new ArrayList<>();
            PriorityQueue<Node> currQueue = entry.getValue();
            
            while (!currQueue.isEmpty()) {
                currList.add(currQueue.poll().treeNode.val);
            }
            result.add(currList);
        }
        
        return result;
    }
}