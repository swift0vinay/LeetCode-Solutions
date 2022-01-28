class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans=0;
        for(int i=1;;i++){
            long sum=(long)i*(i+1);
            sum/=2;
            if(sum>n)
                break;
            sum=sum-n;
            if(sum%i==0)
                ++ans;
        }
        return ans;
    }
}