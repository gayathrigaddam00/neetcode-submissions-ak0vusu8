class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            hm.put(nums1[i],i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int num:nums2){
            while(!st.isEmpty() && num>st.peek()){
                int val = st.pop();
                int idx = hm.get(val);
                res[idx]=num;
            }
            if(hm.containsKey(num)){
                st.push(num);
            }
        }
        return res;
    }
}