class Solution {
    public int[] topKFrequent(int[] ar, int k) {
        if(k==ar.length)
            return ar;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i:ar){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->hm.get(a)-hm.get(b));
        for(Integer i:hm.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}