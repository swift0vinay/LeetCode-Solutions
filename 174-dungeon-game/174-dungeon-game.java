class Solution {
    public int calculateMinimumHP(int[][] ar) {
        int n=ar.length,m=ar[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int[] x:dp) Arrays.fill(x,Integer.MAX_VALUE);
        dp[n-1][m]=1;
        dp[n][m-1]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int need=Integer.min(dp[i+1][j],dp[i][j+1])-ar[i][j];
                dp[i][j]=need<=0?1:need;
            }
        }
       return dp[0][0];
    }
}