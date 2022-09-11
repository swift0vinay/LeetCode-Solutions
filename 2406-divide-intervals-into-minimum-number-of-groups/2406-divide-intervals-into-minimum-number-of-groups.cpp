class Solution {
public:
    int minGroups(vector<vector<int>>& ar) {
        vector<int> dp((int)1e6+2);
        for(int i=0;i<ar.size();i++){
            dp[ar[i][0]]+=1;
            dp[ar[i][1]+1]-=1;
        }
        int mx=0;
        for(int i=1;i<dp.size()-1;i++){
            dp[i]+=dp[i-1];
            mx=max(mx,dp[i]);
        }
        return mx;
    }
};