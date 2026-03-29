class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int c=0;
        int i=a.length()-1,j=b.length()-1;
        while(i>=0 || j>=0 || c>0){
            int a1=i>=0?a.charAt(i)-'0':0;
            int b1 = j>=0?b.charAt(j)-'0':0;

            int total = a1+b1+c;
            res.append(total%2);
            c=total/2;
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}