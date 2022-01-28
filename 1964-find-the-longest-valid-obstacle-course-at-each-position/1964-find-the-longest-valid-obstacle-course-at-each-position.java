class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] ar) {
        int n=ar.length;
        int[] ans=new int[n];
        int dp[]=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int last=-1;
        for(int i=0;i<n;i++){
            if(last==-1){
                dp[++last]=ar[i];
                ans[i]=last+1;
            }else if(ar[i]>=dp[last]){
                dp[++last]=ar[i];
                ans[i]=last+1;
            }else{
                int index=get(dp,ar[i]);
                ans[i]=index+1;
                dp[index]=ar[i];
            }
        }
        return ans;
    }
    int get(int[] dp,int item){
        int start=-1,end=dp.length;
        while(start+1<end){
            int mid=(start+end)/2;
            if(dp[mid]<=item){
                start=mid;
            }else{
                end=mid;
            }
        }
        return start+1;
    }
}