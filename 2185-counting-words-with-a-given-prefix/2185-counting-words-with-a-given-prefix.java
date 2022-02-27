class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans=0;
        for(String s:words){
            int i=0,j=0;
            while(i<s.length() && j<pref.length() && s.charAt(i)==pref.charAt(j)){
                ++i;
                ++j;
            }
            if(j==pref.length())
                ++ans;
        }
        return ans;
    }
}