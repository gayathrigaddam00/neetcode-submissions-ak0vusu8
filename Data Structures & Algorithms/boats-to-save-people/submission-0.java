class Solution {
    public int numRescueBoats(int[] people, int limit) {
         int n = people.length;
         int l=0,r=n-1,res=0;
         Arrays.sort(people);
         while(l<=r){
            int remain=limit-people[r--];
            res++;

            if(l<=r && remain>=people[l]){
                l++;
            }
         }
return res;
    }
}