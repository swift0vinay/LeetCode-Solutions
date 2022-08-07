class Solution {
    public int longestIdealString(String s, int k) {
        int dp[]=new int[26];
        for(int i=0;i<s.length();i++){
            int ind=s.charAt(i)-'a';
            int min=Integer.max(0,ind-k);
            int max=Integer.min(25,ind+k);
            int myMax=0;
            for(int j=min;j<=max;j++){
                myMax=Integer.max(myMax,dp[j]);
            }
            dp[ind]=Integer.max(dp[ind],myMax+1);
        }
        int max=0;
        for(int x:dp) max=Integer.max(max,x);
        return max;
    }
}