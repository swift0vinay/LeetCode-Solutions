class Solution {
    int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
     
    public int minOperations(int[] nums, int[] numsDivide) {
        int min=numsDivide[0];
        for(int x:numsDivide){
            min=gcd(min,x);
        }
        int val=Integer.MAX_VALUE;
        for(int x :nums){
            if(min%x==0){
                val=Integer.min(val,x);
            }
        }
        if(val==Integer.MAX_VALUE)
            return -1;
        int ans=0;
        for(int x :nums){
            if(x<val) ++ans;
        }
        return ans;
    }
}