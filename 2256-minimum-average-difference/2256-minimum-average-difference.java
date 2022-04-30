class Solution {
    public int minimumAverageDifference(int[] nums) {
        long pre[]=new long[nums.length];
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            pre[i]=sum;
        }
        int ind=-1;
        long min=Long.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            long left=pre[i];
            long right=pre[nums.length-1]-pre[i];
            int le = i+1;
            int re = nums.length-le;
            long l = left/le;
            long r = re==0?0:right/re;
            long diff = Math.abs(l-r);
            if(diff<min){
                ind=i;
                min=diff;
            }
        }
        return ind;
    }
}