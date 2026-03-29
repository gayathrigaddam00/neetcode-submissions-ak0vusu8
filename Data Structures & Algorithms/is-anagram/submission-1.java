class Solution {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();
        if(s1!=t1) {return false;}
        Map<Character, Integer> hm = new HashMap<>();
        Map<Character, Integer> hm1 = new HashMap<>();

        for(int i=0;i<s1;i++){
hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            hm1.put(t.charAt(i),hm1.getOrDefault(t.charAt(i),0)+1);
        }
        
        return hm1.equals(hm);
    }
}
