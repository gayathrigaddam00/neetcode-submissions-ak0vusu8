class Solution {
    public int majorityElement(int[] nums) {
        int res=0,c=0;

        for(int num:nums){
            if(c==0){
                res=num;
            }
            c+= (num==res) ? 1 : -1;

        }
        return res;
    }
}