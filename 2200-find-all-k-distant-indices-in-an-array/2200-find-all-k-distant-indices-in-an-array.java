class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++) if(nums[i]==key) set.add(i);
        for(int i=0;i<nums.length;i++){
            for(Integer z:set){
                if(Math.abs(z-i)<=k){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}