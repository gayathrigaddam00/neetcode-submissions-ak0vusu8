class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int max = 0;

        for(int num:nums){
            if(!hs.contains(num-1)){
                int length=1;
                while(hs.contains(num+length)){
                    length++;
                }
                max=Math.max(max,length);
            }
        }
        return max;
    }
}
