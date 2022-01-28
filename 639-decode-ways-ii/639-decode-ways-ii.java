class Solution {
    public int numDecodings(String s) {
        long INF=(long)1e9+7;
        char ar[]=s.toCharArray();
        if(ar[0]=='0')
            return 0;
        int n=s.length();
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            char curr=ar[i-1];
            char prev=i-2>=0?ar[i-2]:'-';
            if(curr!='0'){
                long count=curr=='*'?9L:1L;
                dp[i]+=(dp[i-1]*count)%INF;
            }
            if(prev!='-' && prev!='0'){
                long count=0;
                if(prev=='*' && curr=='*')
                    count=15L;
                else if(prev=='*' && curr!='*'){
                    int id=curr-'0';
                    if(id>6)
                        count=1L;
                    else
                        count=2L;
                }else if(prev!='*' && curr=='*'){
                    int id=prev-'0';
                    if(id<=2){
                        if(id==1)
                            count=9L;
                        else
                            count=6L;
                    }
                }else{
                    int num=Integer.parseInt(prev+""+curr);
                    if(num<=26){
                        count=1L;
                    }
                } 
                dp[i]+=(dp[i-2]*count)%INF;
            }
        }
        int ans=(int)(dp[n]%INF);
        if(ans<0)
            ans+=(int)INF;
        return ans;
    }
}