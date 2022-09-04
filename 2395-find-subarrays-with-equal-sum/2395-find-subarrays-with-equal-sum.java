class Solution {
    public boolean findSubarrays(int[] nums) {
        for(int i=1;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[i-1]==nums[j]+nums[j-1]){
                    return true;
                }
            }
        }
        return false;
    }
}