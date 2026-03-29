class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str:strings) {
            String key=generateKey(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    private String generateKey(String s) {
        if (s.length() == 1) {
            return "single";
        }
        StringBuilder key = new StringBuilder();
        for (int i=1;i<s.length();i++) {
            int diff=(s.charAt(i)-s.charAt(i-1)+26)%26;
            key.append(diff).append("#");
        }
        return key.toString();
    }
}