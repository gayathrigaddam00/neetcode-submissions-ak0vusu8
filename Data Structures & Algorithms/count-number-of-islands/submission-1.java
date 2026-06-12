class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int numIslands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    numIslands+=1;
                    dfs(i,j,grid);
                }
            }
        }
        return numIslands;
    }
    private void dfs(int r,int c,char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]=='0'){
            return ;
        }
        grid[r][c]='0';
        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }
}
