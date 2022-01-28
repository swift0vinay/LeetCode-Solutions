class Solution {
    public int maxProfit(int[] ar) {
        int n=ar.length;
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        int min=ar[0];
        for(int i=1;i<n;i++){
            min=Integer.min(ar[i],min);
            dp1[i]=Integer.max(dp1[i-1],ar[i]-min);
        }
        int max=ar[n-1];
        for(int i=n-2;i>=0;i--){
            max=Integer.max(max,ar[i]);
            dp2[i]=Integer.max(dp2[i+1],max-ar[i]);
        }
        max=0;
        for(int i=0;i<n;i++){
            max=Integer.max(dp1[i]+dp2[i],max);
        }
        return max;
    }
}