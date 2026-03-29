class Solution {
    public int shortestWay(String source, String target) {
        int count=0;  
        int i=0;     
        while (i < target.length()) {
            int start=i;
            for (int j=0; j<source.length();j++) {
                if (i<target.length() && source.charAt(j) == target.charAt(i)) {
                    i++; 
                }
            }
            if (start==i) {
                return -1;
            }
            count++;
        }
        return count;
    }
}