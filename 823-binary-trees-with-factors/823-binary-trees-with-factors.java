class Solution {
    public int numFactoredBinaryTrees(int[] ar) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        Arrays.sort(ar);
        for( int x : ar ) {
            int z = x;
            int count = 1;
            for(int i=2;i<=(int)Math.sqrt(z);i++){
                if(z%i==0){
                    int k =z/i;
                    if(z%k==0){
                        count = add(count,mul(hm.getOrDefault(i,0),hm.getOrDefault(k,0)));
                        if(i!=k)
                            count=add(count,mul(hm.getOrDefault(i,0),hm.getOrDefault(k,0)));
                    }
                }
            }
            hm.put(x,count);
        }
        // System.out.println(hm);
        int ans=0;
        for(Integer z : hm.keySet()) ans=add(ans,hm.get(z));
        return ans;
    }
    
    int mul(int a ,int b){
        long INF=(long)1e9+7;
        long z = (long)a*b;
        return (int)(z%INF);
    }
    
    int add(int a ,int b){
        long INF=(long)1e9+7;
        long z = (long)a+b;
        return (int)(z%INF);
    }
}