class Solution {
    /*
    TC : Olog(min(m,n));
    SC : O(1);
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length>nums2.length ? nums2 : nums1;
        int[] larger = nums1.length>nums2.length ? nums1 : nums2;

        int totalLen = nums1.length+nums2.length;
        int m = smaller.length;
        int n = larger.length;
        int low = 0, high = smaller.length;

        while(low<=high){
            int pX = low+(high-low)/2;
            int pY = (totalLen+1)/2 -pX;
            int l1 = (pX == 0) ? Integer.MIN_VALUE : smaller[pX - 1];
            int r1 = (pX == m) ? Integer.MAX_VALUE : smaller[pX];
            int l2 = (pY == 0) ? Integer.MIN_VALUE : larger[pY - 1];
            int r2 = (pY == n) ? Integer.MAX_VALUE : larger[pY];
            if (l1 <= r2 && l2 <= r1) {
                if (totalLen % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
            else if (l1 > r2) {
                high = pX - 1;
            }
            else{
                low = pX + 1;
            }
        }
        return 0;
    }
}