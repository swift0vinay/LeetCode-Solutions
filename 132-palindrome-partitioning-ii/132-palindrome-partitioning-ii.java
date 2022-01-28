class Solution {
    int DP[][];
    boolean dp[][];
    public int minCut(String s) {
        char ar[]=s.toCharArray();
        int n=ar.length;
        dp=new boolean[n][n];
        DP=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            Arrays.fill(DP[i],-1);
        }
        for(int i=0;i<n-1;i++){
            if(ar[i]==ar[i+1])
                dp[i][i+1]=true;
        }
        for(int len=3;len<=n;len++){
            int start=0,end=len-1;
            while(end<n){
                if(ar[start]==ar[end] && dp[start+1][end-1]){
                    dp[start][end]=true;
                }
                ++start;
                ++end;
            }
        }
        return dfs(ar,n,0)-1;
    }
    int dfs(char[] ar,int n,int start){
        int curr=0;
        int min=Integer.MAX_VALUE;
        for(int i=start;i<n;i++){
            if(dp[start][i]){
                if(i+1 < n && DP[i+1][n-1]==-1){
                  DP[i+1][n-1]=dfs(ar,n,i+1);    
                }
                min=Integer.min(1+(i+1<n?DP[i+1][n-1]:0),min);
            }
        }
        return min;
    }
}