class Solution {
    public int largestCombination(int[] ar) {
        int dp[]=new int[32];
        for(int x:ar){
            for(int i=0;i<32;i++){
                int z= x>>i;
                if((z&1)==1){
                    dp[i]+=1;
                }
            }
        }
        int max=0;
        for(int x:dp) max=Integer.max(max,x);
        return max;
    }
}