class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i+1<nums.length;i++){
            if(key==nums[i]){
                hm.put(nums[i+1],hm.getOrDefault(nums[i+1],0)+1);
            }
        }
        int max=-1;
        key=-1;
        for(Integer z:hm.keySet()){
            if(hm.get(z)>max){
                max=hm.get(z);
                key=z;
            }
        }
        return key;
    }
}