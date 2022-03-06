class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        long ans=0;
        if(nums[0]-1>0){
            ans+=sum(Long.min(k,nums[0]-1));
            k-=Long.min(nums[0]-1,k);
        }
        for(int i=1;i<n;i++){
            if(k<=0)
                break;
            int start=nums[i-1],end=nums[i];
            if(start==end) 
                continue;
            long c=Long.min(k,end-start-1);
            k-=c;
            long base=start;
            long ss= c*base + sum(c);
            ans+=ss;
        }
        if(k>0){
            long base=nums[n-1];
            long c=k;
            long ss=c*base + sum(c);
            ans+=ss;
        }
        return ans;
    }
    long sum(long x){
        long ans=x*(x+1);
        return ans/2;
    }
}