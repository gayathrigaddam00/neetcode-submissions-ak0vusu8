class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while(!visit.contains(n)){
            visit.add(n);
            n=sumofSquares(n);
            if(n==1){
                return true;
            }
        }
        return false;
    }
    private int sumofSquares(int n){
        if(n==0) return 0;
        int res=0;
        while(n>0){
            int digit = n%10;
            digit=digit*digit;
            res+=digit;
            n=n/10;
        }
        return res;
    }
}
