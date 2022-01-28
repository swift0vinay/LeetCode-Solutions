class Solution {
    public int minDistance(String word1, String word2) {
        char a[]=word1.toCharArray(),b[]=word2.toCharArray();
        int n=a.length,m=b.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=m;i++){
            dp[0][i]=dp[0][i-1]+1;
        }
        for(int i=1;i<=n;i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]!=b[j-1]){
                    dp[i][j]=Integer.min(dp[i-1][j],Integer.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }else{
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }
}