class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int x:nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        for(Integer z:hm.keySet()){
            if(hm.get(z)%2!=0)
                return false;
        }
        return true;
    }
}