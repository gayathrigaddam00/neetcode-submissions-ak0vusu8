

class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> hm = new HashMap<>();
        
        int l = 0;
        int maxFreq = 0;
        int maxWindow = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(ch));
            int winLen = r - l + 1;
            if (winLen - maxFreq > k) {
                char leftChar = s.charAt(l);
                hm.put(leftChar, hm.get(leftChar) - 1);
                l++;
            }
            maxWindow = Math.max(maxWindow, r - l + 1);
        }
        
        return maxWindow;
    }
}