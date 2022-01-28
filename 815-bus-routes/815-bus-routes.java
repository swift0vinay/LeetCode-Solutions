class Solution {
    public int numBusesToDestination(int[][] ar, int src, int end) {
        if(src==end) return 0;
        int n=ar.length;
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            Arrays.sort(ar[i]);
            al.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(intersect(ar[i],ar[j])){
                    al.get(i).add(j);
                    al.get(j).add(i);
                }
            }
        }
        boolean visited[]=new boolean[n];
        boolean hasTarget[]=new boolean[n];
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(Arrays.binarySearch(ar[i],src)>=0){
                visited[i]=true;
                dq.add(new int[]{i,0});
            }
            if(Arrays.binarySearch(ar[i],end)>=0){
                hasTarget[i]=true;
            }
        }
        while(!dq.isEmpty()){
             int[] ss=dq.pollFirst();
            int node=ss[0],depth=ss[1];
            if(hasTarget[node]) return depth+1;
            for(Integer z:al.get(node)){
                if(!visited[z]){
                    visited[z]=true;
                    dq.add(new int[]{z,depth+1});
                }
            }
        }
        return -1;
    }
    boolean intersect(int[] x,int[] y){
        int s=0,ss=0;
        while(s<x.length && ss<y.length){
            if(x[s]==y[ss])
                return true;
            if(x[s]<y[ss])
                ++s;
            else
                ++ss;
        }
        return false;
    }
}