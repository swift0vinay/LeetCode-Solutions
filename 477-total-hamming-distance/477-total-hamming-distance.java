class Solution {
    public int totalHammingDistance(int[] ar) {
        int ans=0,n=ar.length;
        for(int bit=0;bit<32;bit++){
            int z=0,o=0;
            for(int i=0;i<n;i++){
                int x=ar[i]>>bit;
                int y=x&1;
                if(y==1){
                    ++o;
                }else{
                    ++z;
                }
            }
            ans+=o*z;
        }
        return ans;
    }
}