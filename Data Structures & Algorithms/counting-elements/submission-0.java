class Solution {
    public int countElements(int[] arr) {
        Set<Integer> hs = new HashSet<>();
        for(int num:arr){
            hs.add(num);
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(hs.contains(arr[i]+1)){
                res++;
            }
        }
        return res;
    }
}
