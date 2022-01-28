class Solution {
    public int minNumberOperations(int[] ar) {
        int ans=ar[0];
        for(int i=1;i<ar.length;i++){
            int diff=ar[i]-ar[i-1];
            if(diff>0) ans+=diff;
        }
        return ans;
    }
}