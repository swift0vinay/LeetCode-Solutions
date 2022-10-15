class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int powers[]=new int[Integer.bitCount(n)];
        int ind=0;
        for(int i=0;i<31;i++){
            int z = n>>i;
            if((z&1)==1){
                powers[ind]=(1<<i);
                ++ind;
            }
        }
        int ans[]=new int[queries.length];
        int MOD = (int)1e9+7;
        for(int i=0;i<queries.length;i++){
            long pro=1;
            for(int j=queries[i][0];j<=queries[i][1];j++) {
                pro*=powers[j];
                pro%=MOD;
            }
            ans[i]=(int)pro;
        }
        return ans;
    }
}