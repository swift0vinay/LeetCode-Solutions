class Solution {
    public int numFactoredBinaryTrees(int[] ar) {
        int MOD = 1_000_000_007;
        int n = ar.length;
        Arrays.sort(ar);
        long dp[]=new long[n];
        Arrays.fill(dp,1);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
            hm.put(ar[i],i);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(ar[i]%ar[j]==0){
                    int right = ar[i]/ar[j];
                    if(hm.containsKey(right)) {
                        dp[i]=(dp[i]+dp[j]*dp[hm.get(right)])%MOD;
                    }
                }
            }
        }
        long ans=0;
        for(long x:dp) ans+=x;
        return (int)(ans%MOD);
    }
}