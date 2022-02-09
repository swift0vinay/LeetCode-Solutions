class Solution {
    public int[] findRightInterval(int[][] ar) {
        int n=ar.length;
        int ans[]=new int[n];
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=ar[i][0];
            dp[i][1]=i;
        }
        Arrays.sort(dp,(a,b)->a[0]-b[0]);
        // for(int[] x:dp)
        //     System.out.println(Arrays.toString(x));
        for(int i=0;i<n;i++){
            int item=ar[i][1];
            int start=-1,end=n;
            boolean rs=false;
            while(start+1<end){
                int mid=(start+end)/2;
                if(dp[mid][0]==item){
                    ans[i]=dp[mid][1];
                    rs=true;
                    break;
                }
                if(dp[mid][0]<item){
                    start=mid;
                }else{
                    end=mid;
                }
            }
            if(rs) continue;
            int index=start+1;
            if(index<n && ar[dp[index][1]][0]>=item){
                ans[i]=dp[index][1];
            }else{
                ans[i]=-1;
            }
        }
        return ans;
    }
}