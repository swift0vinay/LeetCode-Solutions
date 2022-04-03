class Solution {
    public int maximumCandies(int[] candies, long k) {
        int start=0,end=(int)1e7,ans=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(check(candies,mid,k)){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    boolean check(int[] ar,int mid,long k){
        if(mid==0)
            return true;
        long z=0;
        for(int i=0;i<ar.length;i++){
            z+=ar[i]/mid;
        }
        if(z>=k)
            return true;
        return false;
    }
}