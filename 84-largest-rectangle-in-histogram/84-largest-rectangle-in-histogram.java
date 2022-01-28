class Solution {
    public int largestRectangleArea(int[] ar) {
       int n=ar.length;
        int dp[]=new int[n];
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && ar[i]<ar[dq.peekLast()]){
                int index=dq.pollLast();
                int diff=i-index;
                dp[index]=diff;
            }
            dq.add(i);
        }
        while(!dq.isEmpty()){
            int index=dq.pollLast();
            dp[index]=n-index;
        }
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && ar[i]<ar[dq.peekLast()]){
                int index=dq.pollLast();
                int diff=index-i;
                dp[index]+=diff-1;
            }
            dq.add(i);
        }
        while(!dq.isEmpty()){
            int index=dq.pollLast();
            dp[index]+=index;
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Integer.max(max,dp[i]*ar[i]);
        }
        return max;
    }
}