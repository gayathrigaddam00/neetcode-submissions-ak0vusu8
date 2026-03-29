class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        for(int i=0;i<cost.length;i++){
            cache[i]=-1;
        }
        return Math.min(dfs(cost,0),dfs(cost,1));
    }
    private int dfs(int[] cost, int i){
        if(i>=cost.length) return 0;
        if(cache[i]!=-1) return cache[i];
        cache[i]=Math.min(dfs(cost,i+1)+cost[i],dfs(cost,i+2)+cost[i]);

        return cache[i];
    }
}
