class Solution {
    public int minSteps(String s, String t) {
        int dp1[]=new int[26],dp2[]=new int[26];
        for(char x:s.toCharArray())
            dp1[x-'a']+=1;
        for(char x:t.toCharArray())
            dp2[x-'a']+=1;
        int ans=0;
        for(int i=0;i<26;i++){
            ans+=Math.abs(dp1[i]-dp2[i]);
        }
        return ans;
    }
}