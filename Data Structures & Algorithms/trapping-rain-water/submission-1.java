class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        lmax[0]=height[0];

        int[] rmax = new int[n];
        rmax[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],height[i]);
        }
        for(int r=n-2;r>=0;r--){
            rmax[r]=Math.max(rmax[r+1],height[r]);
        }
        int res=0;

        for(int i=0;i<n;i++){
            res+=Math.min(lmax[i],rmax[i])-height[i];
        }
        for(int num:rmax){
            System.out.println(num+" ");
        }

        
        return res;
    }
}
