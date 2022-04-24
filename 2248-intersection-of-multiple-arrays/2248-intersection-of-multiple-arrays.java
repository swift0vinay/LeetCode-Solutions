class Solution {
    public List<Integer> intersection(int[][] nums) {
        int dp[]=new int[1001];
        for(int[] ar:nums){
            for(int x:ar){
                dp[x]+=1;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=1000;i++){
            if(dp[i]==nums.length){
                ans.add(i);
            }
        }
        return ans;
    }
}