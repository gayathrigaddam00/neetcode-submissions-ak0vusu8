class Solution {
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            if(n%2!=0){
                res++;
            }
            n>>=1;
        }
        return res;
    }
}
