class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int start=0,end=0;
        while(end<nums.length){
            if(nums[end]>nums[start]+k){
                ++ans;
                start=end;
            }
            ++end;
        }
        if(nums[end-1]<=nums[start]+k){
            ++ans;
        }
        return ans;
    }
}