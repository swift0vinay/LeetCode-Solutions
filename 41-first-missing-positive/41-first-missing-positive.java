class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean ans[]=new boolean[5*(int)1e5+2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=(5*(int)1e5+2)){
                ans[nums[i]]=true;
            }
        }
        for(int i=1;i<ans.length;i++){
            if(!ans[i])
                return i;
        }
        return 0;
    }
}