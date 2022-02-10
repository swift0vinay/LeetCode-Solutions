class Solution {
    public int findMaxForm(String[] ar, int m, int n) {
        int N=ar.length;
        int dp[][][]=new int[N+1][n+1][m+1];
        int max=0;
        for(int i=1;i<=N;i++){
            int zero=0,one=0;
            for(int j=0;j<ar[i-1].length();j++){
                if(ar[i-1].charAt(j)=='0') ++zero;
            }
            one=ar[i-1].length()-zero;
            for(int j=0;j<=n;j++){
                for(int k=0;k<=m;k++){
                    dp[i][j][k]=dp[i-1][j][k];
                    if(j>=one && k>=zero){
                        dp[i][j][k]=Integer.max(dp[i-1][j-one][k-zero]+1,dp[i][j][k]);
                    }
                    max=Integer.max(dp[i][j][k],max);
                }
            }
        }
        return max;
    }
}