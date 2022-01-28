class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int total=0;
        for(int i:arr2) total^=i;
        int ans=0;
        for(int i:arr1){
            int z=i&total;
            ans^=z;
        }
        return ans;
    }
}