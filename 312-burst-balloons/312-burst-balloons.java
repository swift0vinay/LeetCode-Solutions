class Solution {
    int dp[][];
    int n;
    public int maxCoins(int[] ar) {
        n=ar.length;
        dp=new int[n][n];
        int max=0;
        for(int size=1;size<=n;size++){
            for(int left=0;left+size-1<n;left++){
                int right=left+size-1;
                for(int i=left;i<=right;i++){
                    int a=ar[i]*(left-1<0?1:ar[left-1])*(right+1==n?1:ar[right+1]);
                    int b=(i-1>=0?dp[left][i-1]:0)+(i+1<n?dp[i+1][right]:0);
                    dp[left][right]=Integer.max(dp[left][right],a+b);
                    max=Integer.max(max,dp[left][right]);
                }
            }
        }
        return max;
    }
}