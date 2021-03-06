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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean needReverse = false;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            if (needReverse) {
                Collections.reverse(level);
            }
            
            needReverse = !needReverse;
            result.add(level);
        }
        
        return result;
    }
}