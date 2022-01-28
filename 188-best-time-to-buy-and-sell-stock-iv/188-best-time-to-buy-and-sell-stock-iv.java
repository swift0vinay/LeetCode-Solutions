class Solution {
    public int maxProfit(int k, int[] ar) {
        int n=ar.length;
        int dp[][]=new int[k+1][n+1];
        for(int i=1;i<=k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<=n;j++){
                dp[i][j]=Integer.max(dp[i][j-1],ar[j-1]+max);
                max=Integer.max(max,dp[i-1][j]-ar[j-1]);
            }
        }
        return dp[k][n];
    }
}