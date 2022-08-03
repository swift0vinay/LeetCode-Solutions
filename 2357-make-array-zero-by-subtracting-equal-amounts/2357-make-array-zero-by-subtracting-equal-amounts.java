class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int x : nums){ 
            if(x>0)
                set.add(x);
        }
        return set.size();
    }
}