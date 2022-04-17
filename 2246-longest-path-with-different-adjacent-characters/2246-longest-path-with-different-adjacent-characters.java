class Solution {
    public int longestPath(int[] parent, String s) {
        int longest=0;
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        int n=parent.length;
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            int x=parent[i];
            al.get(x).add(i);
            al.get(i).add(x);
        }
        boolean vis[]=new boolean[n];
        dfs(0,vis,'-',0,s.toCharArray(),al);
        return ans;
    }
    
    int ans=0;
    
    int dfs(int src,boolean[] vis,char parent,int count,char[] ar,ArrayList<ArrayList<Integer>> al){
        vis[src]=true;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
       
        for(Integer z:al.get(src)){
            if(!vis[z]){
                int zz = dfs(z,vis,ar[src],0,ar,al);
                pq.add(new int[]{z,zz});
            }
        }
        int op=0;
        int times=2;
        int curr=0;
        while(times>0 && !pq.isEmpty()){
            int[] z=pq.poll();
            if(ar[src]!=ar[z[0]]){
                --times;
                curr=Integer.max(curr,z[1]);
                op += z[1];
            }
        }
        ans=Integer.max(ans,op+1);
        return parent == ar[src] ? 0 : curr+1;
    }
}