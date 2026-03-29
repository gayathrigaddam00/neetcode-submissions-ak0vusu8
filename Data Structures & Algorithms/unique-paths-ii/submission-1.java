class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;
        memo=new int[r][c];
        for(int[] i:memo){
            Arrays.fill(i,-1);
        }
        return dfs(0,0,obstacleGrid,r,c);
    }
    private int dfs(int i,int j,int[][] obstacleGrid,int r,int c){
        if(i==r || j==c || obstacleGrid[i][j]==1) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if (i== r - 1 && j == c - 1) {
            return 1;}
        return memo[i][j]=dfs(i+1,j,obstacleGrid,r,c)+dfs(i,j+1,obstacleGrid,r,c);
    }
}