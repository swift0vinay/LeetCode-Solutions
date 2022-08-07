class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int dp[]=new int[2];
        for(int x :nums) hm.put(x,hm.getOrDefault(x,0)+1);
        for(Integer z : hm.keySet()) {
            dp[0]+=hm.get(z)/2;
            dp[1]+=hm.get(z)%2;
        }
        return dp;
    }
}