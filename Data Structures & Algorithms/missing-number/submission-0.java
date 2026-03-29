class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int s=0;
       for(int num:nums){
        s+=num;
       }
       return n*(n+1)/2-s;
    }
}
