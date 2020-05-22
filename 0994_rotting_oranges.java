class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int countFresh = 0;
        Queue<Node> q = new LinkedList<Node>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    countFresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new Node(i, j));
                }
            }
        }
        
        if (countFresh == 0) {
            return 0;
        }
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int iterations = 0;
        while (!q.isEmpty()) {
            if (countFresh == 0) {
                return iterations;
            }
            int size = q.size();
            iterations++;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = curr.x + dx[j];
                    int newY = curr.y + dy[j];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        countFresh--;
                        grid[newX][newY] = 2;
                        q.offer(new Node(newX, newY));
                    }
                }
            }
        }
        
        return -1;
    }
}