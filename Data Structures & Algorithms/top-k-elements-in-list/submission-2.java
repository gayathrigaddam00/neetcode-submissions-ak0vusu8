public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        List<Integer>[] freq = new List[nums.length+1];
        for(int i=0;i<nums.length+1;i++){
            freq[i]=new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int idx=0;
        for(int i=freq.length-1;i>0 && idx<k;i--){
            for(int n:freq[i]){
                res[idx++]=n;
                if(idx==k){
                    return res;
                }
            }
        }
        return res;
    }
}