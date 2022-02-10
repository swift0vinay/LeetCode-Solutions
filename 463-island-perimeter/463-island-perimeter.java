class Solution {
    public int islandPerimeter(int[][] ar) {
        int n=ar.length,m=ar[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ar[i][j]==1){
                   return dfs(visited,ar,i,j,n,m);  
                }
            }
        }
        return 0;
    }
    int dfs(boolean[][] visited,int[][] ar,int i,int j,int n,int m){
        if(i<0||i>=n||j<0||j>=m||visited[i][j]||ar[i][j]==0)
            return 0;
        int x=0;
        if(i-1<0||(i-1>=0 && ar[i-1][j]==0))
            ++x;
        if(j-1<0||(j-1>=0 && ar[i][j-1]==0))
            ++x;
        if(i+1>=n || (i+1<n && ar[i+1][j]==0))
            ++x;
        if(j+1>=m || (j+1<m && ar[i][j+1]==0))
            ++x;
        visited[i][j]=true;
        return x+dfs(visited,ar,i-1,j,n,m)+dfs(visited,ar,i+1,j,n,m)+dfs(visited,ar,i,j-1,n,m)+dfs(visited,ar,i,j+1,n,m);
    }
}