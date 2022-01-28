class Solution {
    public int countSpecialSubsequences(int[] ar) {
        int INF=(int)1e9+7;
        int dp[]=new int[3];
        for(int x:ar){
            dp[x]=((dp[x]+dp[x])%INF+(x>0?dp[x-1]:1))%INF;
        }
        return dp[2];
    }
}