class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        int points[]=new int[(int)1e4+1];
        for(int x:nums){
            points[x]+=x;
            max=Integer.max(max,x);
        }
        int dp[]=new int[max+1];
        dp[1]=points[1];
        for(int i=2;i<=max;i++){
            dp[i]=Integer.max(dp[i-1],dp[i-2]+points[i]);
        }
        return dp[max];
    }
}