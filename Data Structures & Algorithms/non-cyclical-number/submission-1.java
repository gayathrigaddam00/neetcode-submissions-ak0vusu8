class Solution {
    public boolean isHappy(int n) {
        int slow=n,fast=sumOfSquares(n);
        while(slow!=fast){
            fast=sumOfSquares(fast);
            fast=sumOfSquares(fast);
            slow=sumOfSquares(slow);
        }
        return fast==1;
    }  
    private int sumOfSquares(int n){
        if(n==0) return 0;
        int res=0;
        while(n>0){
            int d = n%10;
            d=d*d;
            res+=d;
            n=n/10;
        }
        return res;
    }  
}
