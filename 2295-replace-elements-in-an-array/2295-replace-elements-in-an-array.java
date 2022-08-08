class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int dp[]=new int[(int)1e6+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            dp[nums[i]]=i;
        }
        for(int x[] : operations) {
            int ind=dp[x[0]];
            dp[x[0]]=-1;
            dp[x[1]]=ind;
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]==-1) continue;
            nums[dp[i]]=i;
        }
        return nums;
    }
}