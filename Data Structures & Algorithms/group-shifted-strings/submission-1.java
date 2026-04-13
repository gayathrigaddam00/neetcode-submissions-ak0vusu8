class Solution {
    public List<List<String>> groupStrings(String[] strings) {
       Map<String, List<String>> hm = new HashMap<>();
        for(String s:strings){
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
                sb.append(diff).append(',');
            }
            String key = sb.toString();
           hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}