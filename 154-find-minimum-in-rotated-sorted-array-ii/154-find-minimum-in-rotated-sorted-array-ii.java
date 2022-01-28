class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int z:nums) min=Integer.min(z,min);
        return min;
    }
}