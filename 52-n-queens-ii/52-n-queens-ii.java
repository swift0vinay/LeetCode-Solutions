class Solution {
    int[][] dp;
    int ans=0;
    public int totalNQueens(int n) {
        char ar[][]=new char[n][n];
        for(char[] x:ar)
            Arrays.fill(x,'.');
        dp=new int[ar.length][ar[0].length];
        go(ar,0);
        return ans;
    }
    void go(char[][] ar,int row){
        if(row==ar.length){
            int n=ar.length;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(ar[i][j]=='Q' && dp[i][j]>1)
                        return;
                }
            }
            ++ans;
            return;
        }
        int n=ar.length;
        for(int j=0;j<n;j++){
            if(dp[row][j]==0){
                ar[row][j]='Q';
                ++dp[row][j];
                for(int k=0;k<n;k++){
                    if(k!=j)
                        dp[row][k]++;
                    if(k!=row)
                        dp[k][j]++;
                }
                update(row,j,n,true);
                go(ar,row+1);
                --dp[row][j];
                for(int k=0;k<n;k++){
                    if(k!=j)
                    dp[row][k]--;
                    if(k!=row)
                    dp[k][j]--;
                }
                update(row,j,n,false);
                ar[row][j]='.';
            }
        }
    }
    void update(int i,int j,int n,boolean rs){
        int start=i-1,end=j-1;
        while(start>=0 && end>=0){
            dp[start][end]+=rs?1:-1;
            --start;
            --end;
        }
        start=i+1;end=j+1;
        while(start<n && end<n){
            dp[start][end]+=rs?1:-1;
            ++start;
            ++end;
        }
        start=i+1;end=j-1;
        while(start<n && end>=0){
            dp[start][end]+=rs?1:-1;
            ++start;
            --end;
        }
        start=i-1;end=j+1;
        while(start>=0 && end<n){
            dp[start][end]+=rs?1:-1;
            --start;
            ++end;
        }
    }
}