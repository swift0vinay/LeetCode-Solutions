class Solution {
    public int numSubmatrixSumTarget(int[][] ar, int target) {
        int n = ar.length,m = ar[0].length;
        int dp[][] = new int[n][m];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += ar[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for(int j=0;j<m;j++){
            sum += ar[0][j];
            dp[0][j] = sum;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=ar[i][j]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
            }
        }
        // System.out.println("ARRAY ");
        // for(int[] x:dp)
        //     System.out.println(Arrays.toString(x));
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                for(int x=i;x>=0;x--){
                    for(int y=j;y>=0;y--){
                        int left = x-1>=0 ? dp[x-1][j]:0;
                        int up = y-1>=0 ? dp[i][y-1]:0;
                        int corner=0;
                        if(x-1>=0 && y-1>=0){
                            corner=dp[x-1][y-1];
                        }
                        int total=dp[i][j]-left-up+corner;
                        if(total==target){
                            ++ans;
                        }
                    }
                }
            }
        }
        
        return ans;
        
        
    }
}