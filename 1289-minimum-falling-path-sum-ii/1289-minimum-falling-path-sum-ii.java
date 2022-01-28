class Solution {
    public int minFallingPathSum(int[][] ar) {
        int n=ar.length,m=ar[0].length;
        int dp[][]=new int[n][m];
        for(int[] i:dp)
            Arrays.fill(i,Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            dp[0][i]=ar[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    if(k!=j){
                        dp[i][j]=Integer.min(dp[i][j],dp[i-1][k]+ar[i][j]);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min=Integer.min(dp[n-1][i],min);
        }
        return min;
    }
}