class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        long deg[]=new long[n];
        for(int i=0;i<n;i++){
            deg[edges[i]]+=i;
        }
        long max=-1,ind=-1;
        for(int i=0;i<n;i++){
            if(deg[i]>max){
                max=deg[i];
                ind=i;
            }
        }
        return (int)ind;
    }
}