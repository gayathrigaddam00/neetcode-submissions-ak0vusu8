class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        for(String s : strs){
            encoded_string.append(s.length()).append('#').append(s);
        }
        return encoded_string.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i=j+1;
            j=i+length;
            ls.add(str.substring(i,j));
            i=j;
        }
        return ls;
    }
}
