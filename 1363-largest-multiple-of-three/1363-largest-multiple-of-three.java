class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int sum=0;
        int dp[]=new int[10];
        int mod1[]={1,4,7,2,5,8},mod2[]={2,5,8,1,4,7};
        for(int x:digits){
            dp[x]++;
            sum+=x;
        }
        while(sum%3!=0){
            for(Integer i:sum%3==1?mod1:mod2){
                if(dp[i]>0){
                    --dp[i];
                    sum-=i;
                    break;
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=9;i>=0;i--){
            ans.append((i+"").repeat(dp[i]));
        }
        if(ans.length()>0 && ans.charAt(0)=='0')
            return "0";
        return ans.toString();
    }
}