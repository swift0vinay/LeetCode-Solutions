class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                red=true;
                if(!vis[i][j] && grid[i][j]==1){
                    int z= dfs(i,j,n,m,grid,vis);
                    ans+=z;
                }
            }
        }
        return ans;
    }
    int dfs(int i,int j, int n,int m,int[][] grid,boolean[][] vis) {
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || grid[i][j]==0){
            return 0;
        }
        vis[i][j]=true;
        if(i-1<0||i+1>=n||j-1<0||j+1>=m){
            red=false;
        }
        int a = dfs(i-1,j,n,m,grid,vis);
        int b = dfs(i+1,j,n,m,grid,vis);
        int c = dfs(i,j-1,n,m,grid,vis);
        int d = dfs(i,j+1,n,m,grid,vis);
        if(!red)
          return 0;
        return a+b+c+d+1;
    }
    boolean red=false;
}