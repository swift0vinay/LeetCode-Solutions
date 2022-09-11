class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        vector<int>pos(31, 0);
        int ans = 0, last = 0;
        for(int i=0; i<nums.size(); i++){
            for(int j=0; j<31; j++){
                if((nums[i]>>j)&1LL) {
                    last = max(last, pos[j]);
                    pos[j] = i+1;
                }
            }
            ans = max(ans, i+1-last);
        }
        return ans;
    }
};