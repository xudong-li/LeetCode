class Coordiantes {
    public int x;
    public int y;
    public Coordiantes(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    result = Math.max(result, calculateArea(grid, i, j, visited));
                }
            }
        }
        
        return result;
    }
    
    private int calculateArea(int[][] grid, int x, int y, boolean[][] visited) {
        
        int area = 1;
        
        Queue<Coordiantes> q = new LinkedList<>();
        q.offer(new Coordiantes(x,y));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Coordiantes temp = q.poll();
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            for (int i = 0; i < 4; i++) {
                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1 
                    && visited[newX][newY] == false) {
                    q.offer(new Coordiantes(newX,newY));
                    visited[newX][newY] = true;
                    area++;
                }
            }
        }
        
        return area;
    }
}