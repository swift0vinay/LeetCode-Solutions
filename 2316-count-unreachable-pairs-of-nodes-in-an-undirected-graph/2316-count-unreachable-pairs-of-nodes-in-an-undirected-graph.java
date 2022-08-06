class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<Integer>());
        }
        for(int x[] : edges) {
            al.get(x[0]).add(x[1]);
            al.get(x[1]).add(x[0]);
        }
        ArrayList<Integer> components = new ArrayList<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int c=dfs(i,vis,al);
                components.add(c);
            }
        }
        int suff[]=new int[components.size()];
        suff[suff.length-1]=components.get(suff.length-1);
        for(int i=suff.length-2;i>=0;i--){
            suff[i]=suff[i+1]+components.get(i);
        }
        long ans=0;
        for(int i=0;i<components.size()-1;i++){
            ans+=((long)components.get(i)*(suff[i+1]));
        }
        return ans;
    }
    
    int dfs(int i,boolean[] vis,ArrayList<ArrayList<Integer>> al) {
        vis[i]=true;
        int cc=0;
        for(Integer z :al.get(i)){
            if(!vis[z])
                cc+=dfs(z,vis,al);
        }
        return cc+1;
    }
}