class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x=nums[i]-i;
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        long total=((long)nums.length*(nums.length-1))/2;
        long goodPairs=0;
        for(Integer x:hm.keySet()){
            int y = hm.get(x);
            goodPairs += ((long)y*(y-1))/2;
        }
        return total-goodPairs;
    }
}