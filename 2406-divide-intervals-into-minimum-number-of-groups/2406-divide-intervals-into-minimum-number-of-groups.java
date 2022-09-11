class Solution {
    public int minGroups(int[][] ar) {
        int dp[] = new int[(int)1e6+2];
        for(int i=0;i<ar.length;i++){
            dp[ar[i][0]]+=1;
            dp[ar[i][1]+1]-=1;
        }
        int max=0;
        for(int i=1;i<dp.length-1;i++){
            dp[i]+=dp[i-1];
            max=Integer.max(max,dp[i]);
        }
        return max;
    }
}