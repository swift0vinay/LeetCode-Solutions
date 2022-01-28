class Solution {
    int D[][]={{0,-1},{0,1},{-1,0},{1,0}};
    boolean is(int i,int j,int n,int m){
        if(i>=0 && j>=0 && i<n && j<m)
            return true;
        return false;
    }
    public int longestIncreasingPath(int[][] ar) {
        int n=ar.length,m=ar[0].length;
        int ans=1;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int max=dfs(i,j,ar,dp,n,m);
                ans=Integer.max(max,ans);
            }
        }
        return ans;
    }
    int dfs(int i,int j,int[][] ar,int[][] dp,int n,int m){
        if(dp[i][j]!=0)
            return dp[i][j];
        int max=1;
        for(int[] p:D){
            int x=i+p[0],y=j+p[1];
            if(is(x,y,n,m) && ar[x][y]>ar[i][j]){
                max=Integer.max(max,1+dfs(x,y,ar,dp,n,m));
            }
        }
        dp[i][j]=max;
        return max;
    }
}