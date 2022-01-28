class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n,m;
        if(matrix.length==0) return 0;
        n=matrix.length;m=matrix[0].length;
        int ar[][]=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='1'){
                    sum++;
                    ar[i][j]=sum;
                }else{
                    sum=ar[i][j]=0;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Integer.max(max,getMax(ar[i],ar[i].length));
        }
        return max;
    }
    int getMax(int[] ar,int n){
        int dp[]=new int[n];
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && ar[i]<ar[dq.peekLast()]){
                int in=dq.pollLast();
                dp[in]+=i-in;
            }
            dq.add(i);
        }
        while(!dq.isEmpty()){
            int in;
            dp[in=dq.pollLast()]+=n-in;
        }
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && ar[i]<ar[dq.peekLast()]){
                int in=dq.pollLast();
                dp[in]+=in-i-1;
            }
            dq.add(i);
        }
        while(!dq.isEmpty()){
            int in;
            dp[in=dq.pollLast()]+=in;
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Integer.max(max,dp[i]*ar[i]);
        }
        return max;
    }
}