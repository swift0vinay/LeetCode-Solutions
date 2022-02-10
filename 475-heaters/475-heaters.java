class Solution {
    public int findRadius(int[] ar, int[] br) {
        int start=0,end=(int)1e9;
        Arrays.sort(ar);
        Arrays.sort(br);
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            boolean rs=check(ar,br,mid);
            if(rs){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return (int)ans;
    }
    boolean check(int[] ar,int[] br,int mid){
        int done=0;
        int a=0,b=0;
        int left=0,right=0,ans=0;
        while(a<ar.length && b<br.length){
            left=Integer.max(1,br[b]-mid);
            right=Integer.min((int)1e9,br[b]+mid);
            if(ar[a]>=left && ar[a]<=right){
                ++ans;
                ++a;
            }else{
                ++b;
            }
        }
        if(ans==ar.length)
            return true;
        return false;
    }
}