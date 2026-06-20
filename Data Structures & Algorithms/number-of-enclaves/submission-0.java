class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && grid[i][j] == 1) {
                    grid[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] dir : dirs){
                int nr= dir[0]+cell[0];
                int nc = dir[1]+cell[1];
                if(nr>=0 && nr<rows-1 && nc>=0 && nc<cols && grid[nr][nc]==1){
                    grid[nr][nc]=0;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}