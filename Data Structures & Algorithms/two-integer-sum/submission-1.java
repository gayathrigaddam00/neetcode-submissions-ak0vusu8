class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int res = target-nums[i];
            if(hm.containsKey(res)){
                return new int[]{hm.get(res),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }
}
