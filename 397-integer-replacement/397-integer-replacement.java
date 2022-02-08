class Solution {
    HashMap<Long,Integer> hm=new HashMap<>();
    public int integerReplacement(long n) {
        if(n==1)
            return 0;
        if(hm.get(n)!=null)
            return hm.get(n);
        int ans=0;
        if(n%2==0){
            int s=integerReplacement(n/2);
            ans=1+s;
        }else{
            int a=integerReplacement(n-1);            
            int b=integerReplacement(n+1);
            ans=1+Integer.min(a,b);
        }
        hm.put(n,ans);
        return ans;
    }
}