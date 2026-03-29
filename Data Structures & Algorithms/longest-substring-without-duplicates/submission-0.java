class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int l=0;
        int maxLen = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(hs.contains(ch)){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(ch);
            maxLen = Math.max(maxLen,i-l+1);
        }
        return maxLen;
    }
}
