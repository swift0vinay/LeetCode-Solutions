class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
		char ar[]=str1.toCharArray();
        char br[]=str2.toCharArray();
        int n=ar.length,m=br.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
              for(int j=1;j<=m;j++){
                  if(ar[i-1]==br[j-1]){
                      dp[i][j]=dp[i-1][j-1]+1;
                   }else{
                      dp[i][j]=Integer.max(dp[i-1][j],dp[i][j-1]);
                   }
              }
        }
        StringBuilder ans=new StringBuilder();
        int a=n,b=m;
        while(a>0 && b>0 && dp[a][b]!=0){
            if(ar[a-1]==br[b-1]){
                ans.append(ar[a-1]);
                --a;--b;
            }else if(dp[a-1][b]>dp[a][b-1]){
                a-=1;
            }else{
                b-=1;
            }
        }
        ans.reverse();
        char X[]=ans.toString().toCharArray();
        ans=new StringBuilder();
        int start=0;a=0;b=0;
        while(start<X.length){
            while(a<ar.length && ar[a]!=X[start]){
                ans.append(ar[a]);
                ++a;
            }
            while(b<br.length && br[b]!=X[start]){
                ans.append(br[b]);
                ++b;
            }
            ans.append(X[start]);
            ++a;
            ++b;
            ++start;
        }
        while(a<ar.length){
            ans.append(ar[a]);
            ++a;
        }
        while(b<br.length){
            ans.append(br[b]);
            ++b;
        }
        return ans.toString();
	}
}