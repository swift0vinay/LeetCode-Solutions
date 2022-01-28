class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        char ar[]=s.toCharArray();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int len=2;len<=n;len++){
                int start=0,end=start+len-1;
                while(end<n){
                    if(ar[start]!=ar[end]){
                        dp[start][end]=Integer.max(dp[start][end-1],dp[start+1][end]);
                    }else if(len==2){
                        dp[start][end]=2;
                    }else{
                        dp[start][end]=dp[start+1][end-1]+2;
                    }
                    ++start;
                    ++end;
                }
        }
        int length=dp[0][n-1];
        int ans=n-length;
        return ans;
    }
}