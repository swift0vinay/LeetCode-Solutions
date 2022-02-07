class Solution {
    public int minimumTime(String s) {
        char ar[]=s.toCharArray();
        int n=s.length();
        if(n==1){
            if(ar[0]=='0')
                return 0;
            return 1;
        }
        int pre[]=new int[n],suff[]=new int[n];
        pre[0]=ar[0]=='1'?1:0;
        for(int i=1;i<n;i++){
            if(ar[i]=='0')
                pre[i]=pre[i-1];
            else
                pre[i]=Integer.min(pre[i-1]+2,i+1);
        }
        suff[n-1]=ar[n-1]=='1'?1:0;
        int c=2;
        for(int i=n-2;i>=0;i--){
            if(ar[i]=='0')
                suff[i]=suff[i+1];
            else
                suff[i]=Integer.min(suff[i+1]+2,c);
            ++c;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            ans=Integer.min(pre[i]+suff[i+1],ans);
        }
        return ans;
    }
}