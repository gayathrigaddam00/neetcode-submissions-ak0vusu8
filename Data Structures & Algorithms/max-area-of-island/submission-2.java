class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    int area = dfs(i,j,grid);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int r,int c, int[][] grid){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0){
            return 0;
        }
        int area=1;
        grid[r][c]=0;
        area+=dfs(r-1,c,grid);
        area+=dfs(r+1,c,grid);
        area+=dfs(r,c-1,grid);
        area+=dfs(r,c+1,grid);

        return area;
    }
}
