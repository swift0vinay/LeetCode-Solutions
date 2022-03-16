class Solution {
    public int maximumTop(int[] nums, int k) {
        if (k%2 == 1 && nums.length == 1) return -1; // Array becomes empty in this case
        int max = 0;
        for (int i = 0; i < nums.length && i < k-1; i++) {
            max = Math.max(max, nums[i]);
        }
        if (k < nums.length) {
            max = Math.max(max, nums[k]);
        }
        return max;
    }
}