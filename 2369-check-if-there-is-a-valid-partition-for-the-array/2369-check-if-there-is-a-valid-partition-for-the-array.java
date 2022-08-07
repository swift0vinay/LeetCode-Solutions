class Solution {
    Boolean dp[];
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        dp=new Boolean[n];
        return valid(nums,0);
    }
    boolean valid(int[] nums,int ind){
        int n=nums.length;
        if(ind==nums.length)
            return true;
        if(dp[ind]==null){
            boolean a=false,b=false,c=false;
            if(ind+1<n && nums[ind]==nums[ind+1]){
                a=valid(nums,ind+2);
            }
            if(ind+1<n && ind+2<n && nums[ind]==nums[ind+1] && nums[ind+1]==nums[ind+2]){
                b=valid(nums,ind+3);
            }
            if(ind+1<n && ind+2<n && nums[ind+2]-nums[ind+1]==1 && nums[ind+1]-nums[ind]==1){
                c=valid(nums,ind+3);
            }
            dp[ind]=a||b||c;
        }
        return dp[ind];
    }
}