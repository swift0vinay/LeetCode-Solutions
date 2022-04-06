class Solution {
    int ans=0;
    public int maxLength(List<String> arr) {
        int dp[]=new int[26];
        for(int i=0;i<arr.size();i++){
            Arrays.fill(dp,0);
            dfs(i,arr,dp,0);
        }
        return ans;
    }
    void dfs(int i,List<String> ar,int[] dp,int len){
        for(int j=0;j<26;j++){
            if(dp[j]>1)
            {
                return;
            }
        }
        ans=Integer.max(ans,len);
         if(i==ar.size()){
            return;
        }
        for(int j=0;j<ar.get(i).length();j++){
            dp[ar.get(i).charAt(j)-'a']+=1;
        }
        for(int j=i+1;j<=ar.size();j++){
            dfs(j,ar,dp,len+ar.get(i).length());
        }
        for(int j=0;j<ar.get(i).length();j++){
            dp[ar.get(i).charAt(j)-'a']-=1;
        }
    }
}