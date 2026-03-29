class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;
       int[][] dp = new int[r+1][c+1];

       dp[r-1][c-1]=1;
       for(int i=r-1;i>=0;i--){
        for(int j=c-1;j>=0;j--){
            if(obstacleGrid[i][j]==1){
                dp[i][j]=0;
            }else{
            dp[i][j] +=dp[i+1][j]+dp[i][j+1];
            }
        }
        
       }
       return dp[0][0];
    }
}