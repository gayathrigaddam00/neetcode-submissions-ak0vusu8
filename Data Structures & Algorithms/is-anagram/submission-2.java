class Solution {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];

        int sLen = s.length();
        int tLen = t.length();

        if(sLen!=tLen) return false;


        for(int i=0;i<sLen;i++){
            res[s.charAt(i)-'a']++;
            res[t.charAt(i)-'a']--;
        }

        for(int val:res){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}
