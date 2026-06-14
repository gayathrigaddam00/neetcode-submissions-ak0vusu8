

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } 
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            minutes++; 

            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                        && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; 
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}