class Node {
    int x;
    int y;
    int dist;
    public Node (int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    int[] dy = {2, 1,-1, -2, -2, -1, 1, 2};
    
    public int minKnightMoves(int x, int y) {
        // the four directions are symmetic, so we only need to search in one of the four directions
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<String>();
        
        q.offer(new Node(0,0,0));
        visited.add("0-0");
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.x == x && curr.y == y) {
                return curr.dist;
            }
            for (int i = 0; i < 8; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];
                if (!visited.contains(newX + "-" + newY) && newX >= -1 && newY >= -1) {
                    q.offer(new Node(newX, newY, curr.dist + 1)); 
                    visited.add(newX + "-" + newY);
                }
            }
        }
        
        return -1;
    }
}