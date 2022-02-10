class Solution {
    public int minMoves2(int[] ar) {
        int n=ar.length;
        Arrays.sort(ar);
        int ans=0;
        for(int i=0;i<ar.length;i++){
            ans+=Math.abs(ar[i]-ar[n/2]);
        }
        if(n%2==0){
            int ans2=0;
            for(int i=0;i<ar.length;i++){
                ans2+=Math.abs(ar[i]-ar[n/2-1]);
            }
            ans=Integer.min(ans,ans2);
        }
        return ans;
    }
}