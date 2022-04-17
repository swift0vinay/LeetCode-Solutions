class Solution {
    public int findClosestNumber(int[] nums) {
        int close=nums[0];
        for(int i=0;i<nums.length;i++){
            int dist=Math.abs(close);
            int curr=Math.abs(nums[i]);
            if(curr<dist){
                close=nums[i];
            }else if(curr==dist){
                close=Integer.max(close,nums[i]);
            }
        }
        return close;
    }
}