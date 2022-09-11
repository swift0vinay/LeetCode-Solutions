class Solution {
    public int longestNiceSubarray(int[] ar) {
        int ans=0;
        for(int i=0;i<ar.length;i++){
            int dp[]=new int[32];
            boolean rs=true;
            for(int j=i;j<Integer.min(i+32,ar.length);j++){
                for(int k=0;k<32;k++){
                    int z = ar[j]>>k;
                    if((z&1)==1){
                        dp[k]+=1;
                    }
                }
                for(int k=0;k<32;k++){
                    if(dp[k]>1){
                        ans=Integer.max(ans,j-i);
                        rs=false;
                        break;
                    }
                }
                if(!rs)
                    break;
            }
            if(rs){
                ans=Integer.max(Integer.min(ar.length,i+32)-i,ans);
            }
        }
        return ans;
    }
}