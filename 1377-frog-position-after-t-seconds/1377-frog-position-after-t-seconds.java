class Solution {
    double ans=0.0;
    boolean found=false;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++) al.add(new ArrayList<>());
        for(int ss[]:edges){
            al.get(ss[0]-1).add(ss[1]-1);
            al.get(ss[1]-1).add(ss[0]-1);
        }
        int size[]=new int[n];
        boolean visited[]=new boolean[n];
        dfs(al,size,0,visited);
        visited=new boolean[n];
        dfs2(al,size,0,visited,target-1,1.0,t,0);
        return ans;
    }
    void dfs2(ArrayList<ArrayList<Integer>> al,int[] size,int src,boolean[] visited,int T,double pro,int time,int curr){
        // System.out.println(src+" "+curr+" "+pro+" "+T);
        visited[src]=true;
        if(src==T){
            found=true;
            if(curr<=time && size[src]==0)
                ans=pro;
            else if(curr==time)
                ans=pro;
            return;
        }
        for(Integer z:al.get(src)){
            if(!visited[z]){
                dfs2(al,size,z,visited,T,pro*((double)1/size[src]),time,curr+1);
                if(found)
                    return;
            }
        }
    }
    void dfs(ArrayList<ArrayList<Integer>> al,int[] size,int src,boolean[] visited){
        visited[src]=true;
        int c=0;
        for(Integer z:al.get(src)){
            if(!visited[z]){
                ++c;
                dfs(al,size,z,visited);
            }
        }
        size[src]=c;
    }
}