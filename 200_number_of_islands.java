class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
};

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int result = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j, visited);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(x, y));
        visited[x][y] = true;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while (!q.isEmpty()) {
            Coordinate temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && 
                    !visited[newX][newY] && grid[newX][newY] == '1') {
                    q.offer(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        
        return;
        
    }
}