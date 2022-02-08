class Solution {
    public int findNthDigit(int nn) {
        long n=(long)nn;
        long dp[]=new long[11];
        long x=1;
        for(int i=1;i<11;i++){
            dp[i]=(long)9*x;
            x*=10;
        }
        long num=0;
        long prev=0,prevPrev=0;
        for(int i=1;i<11;i++){
            if(prev>=n){
                long gap=(long)(Math.ceil(((double)n-prevPrev)/(i-1)));
                // System.out.println("GAP IS "+" "+prevPrev+ " "+gap);
                prevPrev+=(gap-1)*(i-1);
                num=dp[i-1]/9-1+gap;
                break;
            }else{
                prevPrev=prev;
                prev+=dp[i]*i;
            }
        }
        // System.out.println(num+" "+prevPrev);
        char ss[]=(num+"").toCharArray();
        int in=-1;
        while(prevPrev!=n){
            ++prevPrev;
            ++in;
        }
        return ss[in]-'0';
    }
}