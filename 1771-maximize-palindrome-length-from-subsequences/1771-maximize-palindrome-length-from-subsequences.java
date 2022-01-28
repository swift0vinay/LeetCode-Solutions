class Solution {
    public int longestPalindrome(String word1, String word2) {
        char a[]=(word1.concat(word2)).toCharArray();
        int n=a.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        int start=0,max=0;
        int end=word1.length();
        for(int len=2;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j=i+len-1;
                if(a[i]==a[j]){
                    if(len==2){
                        dp[i][j]=2;
                    }else{
                       dp[i][j]=dp[i+1][j-1]+2;
                    }
                    if(i<end && j>=end ){
                        max=Integer.max(max,dp[i][j]);
                    }
                }else{
                    dp[i][j]=Integer.max(dp[i+1][j],dp[i][j-1]);
                }
            } 
        }
        return max;
    }
}