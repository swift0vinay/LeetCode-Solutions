class Solution {
    public List<Integer> replaceNonCoprimes(int[] ar) {
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        dq.add(ar[0]);
        for(int i=1;i<ar.length;i++){
            int gcd=gcd(dq.peekLast(),ar[i]);
            if(gcd==1){
                dq.add(ar[i]);
            }else{
                int a=ar[i],b=dq.pollLast();
                int lcm=(a / gcd(a, b)) * b;
                if(dq.isEmpty()){
                    dq.add(lcm);
                }else{
                    int x=0;
                    while(!dq.isEmpty() && (x=gcd(dq.peekLast(),lcm))!=1){
                        int e=dq.pollLast();
                        int l=(e/x)*lcm;
                        lcm=l;
                    }
                    dq.add(lcm);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        ans.addAll(dq);
        return ans;
    }
    
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
}