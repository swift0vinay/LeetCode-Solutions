class Solution {
    public int maximumScore(int[] ar, int k) {
        int ans=ar[k],n=ar.length;
//         int min=ar[k],len=1;
//         for(int i=k-1;i>=0;i--){
//             ++len;
//             min=Integer.min(min,ar[i]);
//             ans=Integer.max(ans,min*len);
//         }
//         len=1; min=ar[k];
//         for(int i=k+1;i<n;i++){
//             ++len;
//             min=Integer.min(min,ar[i]);
//             ans=Integer.max(ans,min*len);
//         }
        
        ArrayDeque<Integer> dq=new ArrayDeque<Integer>();
        int dp[]=new int[n],dp2[]=new int[n];
        for(int i=0;i<n;i++) dp[i]=dp2[i]=-1;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && ar[dq.peekFirst()]>ar[i]){
                int ind=dq.pollFirst();
                dp[ind]=i-1;
            }
            dq.addFirst(i);
        }
        while(!dq.isEmpty()){
            int ind=dq.pollFirst();
            dp[ind]=n-1;
        }
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && ar[dq.peekFirst()]>ar[i]){
                int ind=dq.pollFirst();
                dp2[ind]=i+1;
            }
            dq.addFirst(i);
        }
        while(!dq.isEmpty()){
            int ind=dq.pollFirst();
            dp2[ind]=0;
        }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(dp2));
        for(int i=0;i<n;i++){
            int left=Integer.min(i,dp2[i]);
            int right=Integer.max(i,dp[i]);
            if(left<=k && k<=right){
                int length=right-left+1;
                // System.out.println(i+" "+left+" "+right+" "+length);
                ans=Integer.max(length*ar[i],ans);
            }
        }
        return ans;
    }
}