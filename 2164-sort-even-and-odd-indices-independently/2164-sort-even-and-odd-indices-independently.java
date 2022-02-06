class Solution {
    public int[] sortEvenOdd(int[] ar) {
        int n=ar.length;
        int ans[]=new int[n];
        PriorityQueue<Integer> al=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=1;i<n;i+=2)
            al.add(ar[i]);
        int start=1;
        while(!al.isEmpty()){
            ar[start]=al.poll();
            start+=2;
        }
        al=new PriorityQueue<>();
        for(int i=0;i<n;i+=2)
            al.add(ar[i]);
        start=0;
        while(!al.isEmpty()){
            ar[start]=al.poll();
            start+=2;
        }
        return ar;
    }
}