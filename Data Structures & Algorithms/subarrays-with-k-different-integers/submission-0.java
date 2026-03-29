class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int[] nums, int K) {
        Map<Integer,Integer> hm=new HashMap<>();
        int l=0,res=0,r=0;
        while(r<nums.length){
            hm.put(nums[r], hm.getOrDefault(nums[r], 0)+1);
            if (hm.get(nums[r]) == 1) {
                K--;
            }
            while(K<0) {
                hm.put(nums[l], hm.get(nums[l]) - 1);
                if (hm.get(nums[l]) == 0) {
                    K++;
                }
                l++;
            }
            res+=(r-l+ 1);
            r++;
        }
        return res;
    }
}