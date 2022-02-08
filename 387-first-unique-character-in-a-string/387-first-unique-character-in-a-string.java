class Solution {
    public int firstUniqChar(String s) {
        int dp[]=new int[26];
        Arrays.fill(dp,-2);
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(dp[x-'a']==-1)
                continue;
            if(dp[x-'a']==-2){
                dp[x-'a']=i;
                continue;
            }
            dp[x-'a']=-1;
        }
        int n=s.length();
        int ans=n;
        for(int i=0;i<26;i++){
            if(dp[i]>=0)
                ans=Integer.min(ans,dp[i]);
        }
        if(ans==n)
            return -1;
        return ans;
    }
}