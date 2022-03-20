class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq=new PriorityQueue<Double>(Comparator.reverseOrder());
        double sum=0;
        for(int x:nums){
            sum+=x;
            pq.add((double)x);
        }
        int moves=0;
        double half=sum/2;
        while(sum>half){
            double x=pq.poll();
            sum-=x;
            x/=2;
            sum+=x;
            if(x>0)
                ++moves;
            pq.add(x);
        }
        return moves;
    }
}