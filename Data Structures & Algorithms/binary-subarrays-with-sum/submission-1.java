class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindow(nums,goal)-slidingWindow(nums,goal-1);
    }
    private int slidingWindow(int[] nums, int goal){
        if(goal<0) return 0;
        int l=0,r=0,res=0,curr=0;
        while(r<nums.length){
            curr+=nums[r];
            while(curr>goal){
                curr-=nums[l];
                l++;
            }
            res+=(r-l+1);
            r++;
        }
        return res;
    }

}