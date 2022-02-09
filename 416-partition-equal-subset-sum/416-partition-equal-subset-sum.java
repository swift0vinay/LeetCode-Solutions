class Solution {
    public boolean canPartition(int[] ar) {
        int sum=0;
        int n=ar.length;
        for(int i=0;i<n;i++)
            sum+=ar[i];
        if(sum%2!=0)
            return false;
        sum=sum/2;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            int element=ar[i-1];
            for(int j=1;j<=sum;j++){
                if(j<element){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-element];
                }
            }
        }
        return dp[n][sum];
    }
}