class Solution {
    public long minimumDifference(int[] ar) {
        int n=ar.length;
        long pre[]=new long[n],suff[]=new long[n];
        int part=n/3;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
        int start=0;
        long sum=0;
        for(;start<part;start++){
            sum+=ar[start];
            pq.add(ar[start]);
        }
        pre[start-1]=sum;
        for(;start<ar.length;start++){
            pq.add(ar[start]);
            sum+=ar[start];
            while(pq.size()>part){
                sum-=pq.poll();
            }
            pre[start]=sum;
        }
        pq=new PriorityQueue<Integer>();
        start=n-1;
        sum=0;
        for(;start>2*part;start--){
            sum+=ar[start];
            pq.add(ar[start]);
        }
        suff[start]=sum;
        for(;start>=0;start--){
            pq.add(ar[start]);
            sum+=ar[start];
            while(pq.size()>part){
                sum-=pq.poll();
            }
            suff[start]=sum;
        }
        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(suff));
        long ans=Long.MAX_VALUE;
        for(int i=part-1;i<2*part;i++){
            ans=Long.min(ans,pre[i]-suff[i+1]);
        }
        return ans;
    }
}