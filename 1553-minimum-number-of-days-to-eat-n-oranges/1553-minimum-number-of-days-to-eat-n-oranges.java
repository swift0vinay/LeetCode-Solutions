class Solution {
    HashMap<Integer,Integer> hm=new HashMap<>();
    public int minDays(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(hm.get(n)!=null)
            return hm.get(n);
        int ans=Integer.MAX_VALUE;
        ans=Integer.min(ans,n%2+minDays(n/2));
        ans=Integer.min(ans,n%3+minDays(n/3));
        hm.put(n,ans+1);
        return ans+1;
    }
}