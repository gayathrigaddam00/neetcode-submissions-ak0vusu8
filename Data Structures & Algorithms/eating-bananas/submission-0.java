class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int r = 0;
        for(int pile :piles){
            r=Math.max(r,pile);
        }

        while(l<r){
            int m = l+(r-l)/2;

            if(canEat(piles,h,m)){
                r=m;
            }
            else{
                l=m+1;
            }

        }
        return l;
    }

    private boolean canEat(int[] piles,int h,int m){
        int resTime = 0;
        for(int pile:piles){
            resTime +=(int)Math.ceil((double)pile/m);
        }
        return resTime<=h;
    }
}
