class Solution {
    public long numberOfWays(String s) {
        long ans=0;
        char ar[]=s.toCharArray();
        int n=ar.length;
        int zero[]=new int[n],ones[]=new int[n];
        int z=0,o=0;
        for(int i=0;i<n;i++){
            if(ar[i]=='0')
                ++z;
            else
                ++o;
            zero[i]=z;
            ones[i]=o;
        }
        for(int i=0;i<n;i++){
            long left=0,right=0;
            if(ar[i]=='1'){
                left=i-1>=0?zero[i-1]:0;
                right=zero[n-1]-zero[i];
            }else{
                left=i-1>=0?ones[i-1]:0;
                right=ones[n-1]-ones[i];
            }
            ans+=left*right;
        }
        return ans;
    }
}