class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long start=1,end=(long)1e14,ANS=Long.MAX_VALUE;
        while(start<=end){
            long mid=start+(end-start)/2;
            boolean ans=check(time,mid,totalTrips);
            if(ans){
                ANS=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ANS;
    }
    boolean check(int[] time,long mid,int T){
        long counter=0;
        for(int i=0;i<time.length;i++){
            counter+=((long)mid/time[i]);
        }
        if(counter>=T)
            return true;
        return false;
    }
}