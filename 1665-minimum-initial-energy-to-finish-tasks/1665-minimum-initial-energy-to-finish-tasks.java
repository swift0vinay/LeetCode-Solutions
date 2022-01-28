class Solution {
    public int minimumEffort(int[][] ar) {
        Arrays.sort(ar,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int ans=0,have=0;
        for(int i=0;i<ar.length;i++){
            if(have<ar[i][1]){
                ans+=ar[i][1]-have;
                have=ar[i][1];
            }
            have-=ar[i][0];
        }
        return ans;
    }
}