class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s : strs){
            int[] resArr = new int[26];
            for(int i=0;i<s.length();i++){
                resArr[s.charAt(i)-'a']++;
            }
            String key = Arrays.toString(resArr);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
