class Solution {
    long mod=-1;
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        mod=modulo;
        int ind=-1;
        char ar[]=s.toCharArray();
        long curr=0;
        long p=0,zz=0;
        for(int i=ar.length-k;i<ar.length;i++){
            p=calcpow(power,zz);
            long ch=(ar[i]-'a')+1L;
            curr=add(curr,mul(ch,p));
            ++zz;
        }
        // p=mul(power,k-1);
        if(hashValue==curr){
            ind=ar.length-k;
        }
        int start=ar.length-1;
        for(int i=ar.length-1-k;i>=0;i--){
            curr=add(curr,-mul(p,(ar[start]-'a'+1)));
            curr=mul(curr,power);
            curr=add(curr,(ar[i]-'a'+1));
            // System.out.println(ar[i]+" "+ar[start-1]+" "+curr);
            if(curr==hashValue)
                ind=i;
            --start;
        }
        if(ind!=-1)
            return s.substring(ind,ind+k);
        else
            return "";
    }
    long calcpow(long num, long k)
    {
        long  n = num;
        long  ans = 1;
        while(k>0)
        {
            if(k%2 == 0)
            {
                k = k>>1;
                 n = (n*n)%mod;
            }
            else
            {
                k--;
                ans = (ans*n)%mod;
            }
        }
        return ans;
    }
    long add(long a,long b){
        long z=(a+b)%mod;
        if(z<0) z+=mod;
        return z;
    }
    long mul(long a,long b){
        long z=(a%mod*b%mod)%mod;
        return z;
    }
}