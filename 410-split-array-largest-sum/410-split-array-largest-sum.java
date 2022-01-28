class Solution {
    public int splitArray(int[] ar, int m) {
        int sum=0;
        for(int x:ar) sum+=x;
        int start=0,end=sum,ans=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(poss(ar,mid,m,ar.length)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    boolean poss(int[] ar,int mid,int m,int n){
        int parts=1,sum=0;
        for(int i=0;i<n;i++){
            sum+=ar[i];
            if(ar[i]>mid)
                return false;
            if(sum>mid){
                sum=ar[i];
                ++parts;
            }
        }
        return parts<=m?true:false;
    }
}