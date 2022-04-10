class Solution {
    int INF=(int)1e9+7;
    public int maximumProduct(int[] ar, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int x:ar) pq.add(x);
        while(k>0){
            --k;
            int x=pq.poll();
            pq.add(x+1);
        }
        int ans=pq.poll();
        while(!pq.isEmpty()){
            ans=mul(ans,pq.poll());
        }
        return ans;
    }
    int mul(int a,int b){
        long z=(long) a*b;
        return (int)(z%INF);
    }
}