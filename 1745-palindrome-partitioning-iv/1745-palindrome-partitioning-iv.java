class Solution {
    public boolean checkPartitioning(String s) {
        char ar[]=s.toCharArray();
        int n=ar.length;
        boolean dp[][]=new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        for(int i=0;i<n-1;i++){
            if(ar[i]==ar[i+1]){
                dp[i][i+1]=true;
            }
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
        for(int i=0;i<n;i++){
            for(int j=i+1;j+1<n;j++){
                boolean a=dp[0][i];
                boolean b=dp[i+1][j];
                boolean c=dp[j+1][n-1];
                if(a&&b&&c)
                    return true;
            }
        }
        return false;
    }
}