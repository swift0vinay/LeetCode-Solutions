class Solution {
    public int arrangeCoins(int n) {
        long start=0,end=n;
        while(start<=end){
            long mid=start+(end-start)/2;
            long s=(mid*(mid+1)/2);
            if(s==n)
            {
                return (int)mid;
            }
            if(s<n)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return (int)end;
    }
}