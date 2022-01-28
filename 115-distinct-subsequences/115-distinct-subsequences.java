class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
        }
        char ar[]=s.toCharArray();
        char br[]=t.toCharArray();
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(ar[j-1]==br[i-1])
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                else
                    dp[i][j]=dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}