class Solution {
    int n,m;
    int obs=0;
    boolean[][] visited;
    int ans=0;
    public int uniquePathsIII(int[][] ar) {
        n=ar.length;m=ar[0].length;
        visited=new boolean[n][m];
        int a=-1,b=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ar[i][j]==1){
                    a=i;b=j;
                }
                if(ar[i][j]==-1)
                    ++obs;
            }
        }
        dfs(a,b,ar,0);
        return ans;
    }
    void dfs(int i,int j,int[][] ar,int count){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || ar[i][j]==-1)
            return ;
        if(ar[i][j]==2){
            if(count-1==n*m-2-obs){
                ++ans;
            }
            return;
        }
        visited[i][j]=true;
        dfs(i-1,j,ar,count+1);
        dfs(i+1,j,ar,count+1);
        dfs(i,j-1,ar,count+1);
        dfs(i,j+1,ar,count+1);
        visited[i][j]=false;
    }
}