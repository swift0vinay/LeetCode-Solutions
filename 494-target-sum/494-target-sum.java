class Solution {
    public int findTargetSumWays(int[] ar, int T) {
          int dp[][]=new int[ar.length][2001];
        for(int[] row:dp)
            Arrays.fill(row,Integer.MIN_VALUE);
        return cal(ar,0,0,T,dp);
    }
    int cal(int[] ar,int index,int sum,int T,int[][] dp){
        if(index==ar.length){
            if(sum==T)
                return 1;
            return 0;
        }
        if(dp[index][sum+1000]!=Integer.MIN_VALUE)
            return dp[index][sum+1000];
        int add=cal(ar,index+1,sum+ar[index],T,dp);
        int subtract=cal(ar,index+1,sum-ar[index],T,dp);
        dp[index][sum+1000]=add+subtract;
        return dp[index][sum+1000];
    }
}