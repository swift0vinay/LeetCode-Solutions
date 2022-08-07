class Solution {
    public int maximumXOR(int[] nums) {
        int dp[]=new int[32];
        for(int x:nums){
            for(int i=0;i<32;i++){
                int z=x>>i;
                if((z&1)==1){
                    dp[i]+=1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<32;i++){
            if(dp[i]%2==0){
                dp[i]-=1;
            }
            if(dp[i]>0){
                ans+=1<<i;
            }
        }
        return ans;
    }
}