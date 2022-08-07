class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++)
            al.add(new ArrayList<Integer>());
        for(int x[]:edges){
            al.get(x[0]).add(x[1]);
            al.get(x[1]).add(x[0]);
        }
        boolean vis[]=new boolean[n];
        for(int x:restricted) vis[x]=true;
        dfs(0,al,vis);
        return ans;
    }
    void dfs(int src,ArrayList<ArrayList<Integer>> al,boolean[] vis){
        vis[src]=true;
        ++ans;
        for(Integer z:al.get(src)){
            if(!vis[z]){
                dfs(z,al,vis);
            }
        }
    }
    int ans=0;
}