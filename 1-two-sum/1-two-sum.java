class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.get(target-nums[i])!=null){
                int ans[]={i,hm.get(target-nums[i])};
                return ans;
            }
            hm.put(nums[i],i);
        }
        return null;
    }
}