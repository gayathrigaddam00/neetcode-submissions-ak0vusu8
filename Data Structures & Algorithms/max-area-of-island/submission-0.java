class Solution {
    int maxarea=0;
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    maxarea=Math.max(maxarea,dfs(grid,visited,i,j));
                }
            }
             
        }
       return maxarea;
    }
    private int dfs(int[][] grid,boolean[][] visited, int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || visited[i][j]){
            return 0;
        }
        
        visited[i][j]=true;
        int area=1;
        area+=dfs(grid,visited,i+1,j);
        area+=dfs(grid,visited,i-1,j);
        area+=dfs(grid,visited,i,j+1);
        area+=dfs(grid,visited,i,j-1);

        return area;
    }
    
}
