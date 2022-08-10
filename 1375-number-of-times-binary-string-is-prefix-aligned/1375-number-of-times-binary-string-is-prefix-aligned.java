class Solution {
    public int numTimesAllBlue(int[] l) {
        int ans=0;
        int right=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<l.length;i++){
            pq.add(l[i]);
            while(!pq.isEmpty() && pq.peek()<=i+1)
                pq.poll();
            if(pq.size()==0)
                ++ans;
        }
        return ans;
    }
}