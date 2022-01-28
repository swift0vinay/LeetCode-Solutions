class Solution {
    int n,m;
    boolean visited1[][],visited2[][];
    int counter=0,token=0;
    int dp[][],id[][];
    public int largestIsland(int[][] ar) {
        n=ar.length;
        m=ar[0].length;
        visited1=new boolean[n][m];
        visited2=new boolean[n][m];
        dp=new int[n][m];
        id=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited1[i][j] && ar[i][j]==1){
                    counter=0;
                    dfs(ar,i,j);
                    dfs2(ar,i,j);
                    ++token;
                }
            }
        }
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ar[i][j]==0){
                    int curr=1;
                    HashSet<Integer> ids=new HashSet<Integer>();
                    if(check(i-1,j) && ar[i-1][j]==1 && !ids.contains(id[i-1][j])){
                        ids.add(id[i-1][j]);
                        curr+=dp[i-1][j];
                    }
                    if(check(i+1,j) && ar[i+1][j]==1 && !ids.contains(id[i+1][j])){
                        ids.add(id[i+1][j]);
                        curr+=dp[i+1][j];
                    }
                    if(check(i,j-1) && ar[i][j-1]==1 && !ids.contains(id[i][j-1])){
                        ids.add(id[i][j-1]);
                        curr+=dp[i][j-1];
                    }
                    if(check(i,j+1) && ar[i][j+1]==1 && !ids.contains(id[i][j+1])){
                        ids.add(id[i][j+1]);
                        curr+=dp[i][j+1];
                    }
                    max=Integer.max(max,curr);
                }else {
                    max=Integer.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
    
    boolean check(int x,int y){
        if(x>=0 && y>=0 && x<n && y<m)
            return true;
        return false;
    }
    void dfs2(int[][] ar,int i,int j){
        if(i<0||j<0||i>=n||j>=m||ar[i][j]==0||visited2[i][j])
            return;
        dp[i][j]=counter;
        visited2[i][j]=true;
        dfs2(ar,i-1,j);
        dfs2(ar,i+1,j);
        dfs2(ar,i,j-1);
        dfs2(ar,i,j+1);
    }
    
    void dfs(int[][] ar,int i,int j){
        if(i<0||j<0||i>=n||j>=m||ar[i][j]==0||visited1[i][j])
            return;
        ++counter;
        visited1[i][j]=true;
        id[i][j]=token;
        dfs(ar,i-1,j);
        dfs(ar,i+1,j);
        dfs(ar,i,j-1);
        dfs(ar,i,j+1);
    }
}