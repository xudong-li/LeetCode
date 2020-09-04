//O(m^2n^2)
// class Solution {
//     public void wallsAndGates(int[][] rooms) {
//         if (rooms.length == 0) {
//             return;
//         }
        
//         int[][] visited = new int[rooms.length][rooms[0].length];
        
//         for (int i = 0; i < rooms.length; i++) {
//             for (int j = 0; j < rooms[0].length; j++) {
//                 if (rooms[i][j] == 0) {
//                     visited[i][j] = 1;
//                     dfs(rooms, i, j, visited, 0);
//                     visited[i][j] = 0;
//                 }
//             }
//         }
        
//         return;
//     }
    
//     private void dfs(int[][] rooms, int x, int y, int[][] visited, int dist) {
//         rooms[x][y] = Math.min(rooms[x][y], dist);
        
//         int[] dx = {1, 0, -1, 0};
//         int[] dy = {0, -1, 0, 1};
        
//         for (int i = 0; i < 4; i++) {
//             int newX = x + dx[i];
//             int newY = y + dy[i];
//             if (newX >= 0 && newX < rooms.length && newY >= 0 && newY < rooms[0].length 
//                 && rooms[newX][newY] != -1 && rooms[newX][newY] != 0 && visited[newX][newY] == 0) {
//                 visited[newX][newY] = 1;
//                 dfs(rooms, newX, newY, visited, dist + 1);
//                 visited[newX][newY] = 0;
//             }
//         }
        
//     }
// }

// O(mn)
class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}