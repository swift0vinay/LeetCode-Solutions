class Solution {
    public boolean isSubsequence(String s, String t) {
        int a=0,b=0;
        while(a<s.length() && b<t.length()){
            if(s.charAt(a)==t.charAt(b)){
                ++a;
                ++b;
                if(a==s.length())
                    return true;
            }else{
                ++b;
            }
        }
        if(a==s.length())
            return true;
        return false;
    }
}