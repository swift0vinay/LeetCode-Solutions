class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans=0;
        HashMap<Integer,Integer> prev=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> next=new HashMap<Integer,Integer>();
        for(int x:nums) next.put(x,next.getOrDefault(x,0)+1);
        for(int i=0;i<nums.length;i++){
            if(next.get(nums[i])==1){
                next.remove(nums[i]);
            }else{
                next.put(nums[i],next.get(nums[i])-1);
            }
            if(prev.containsKey(nums[i]-diff) && next.containsKey(nums[i]+diff)){
                ++ans;
            }
            prev.put(nums[i],prev.getOrDefault(nums[i],0)+1);
        }
        return ans;
    }
}