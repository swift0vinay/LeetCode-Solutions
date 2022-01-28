class Solution {
    int INF=(int)1e9+7;
    long gcd(long a,long b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    long lcm_ab;
    public int nthMagicalNumber(int n, int a, int b) {
        lcm_ab=lcm((long)a,(long)b);
        long start=0,end=(long)1e18;
        while(start<=end){
            long mid=start+(end-start)/2;
            boolean rs=false;
            long cal=cal(mid,(long)a,(long)b);
            if(mid%a==0||mid%b==0||mid%lcm_ab==0)
                rs=true;
            if(cal==n && rs){
                return (int)(mid%INF);
            }else if(cal<n){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return 0;
    }
    long cal(long mid,long a,long b){
        long aa=mid/a,bb=mid/b,cc=mid/lcm_ab;
        return aa+bb-cc;
    }
}