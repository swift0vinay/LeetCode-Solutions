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
        int max1=0,max2=0;
        for(Integer z:al.get(src)){
            if(!vis[z]){
                int zz = dfs(z,vis,ar[src],0,ar,al);
                if(ar[z]!=ar[src]){
                    if(zz>max1){
                        max2=max1;
                        max1=zz;
                    }else if(zz>max2){
                        max2=zz;
                    }
                }
            }
        }
        int op=max1+max2;
        int curr=max1;
        ans=Integer.max(ans,op+1);
        return parent == ar[src] ? 0 : curr+1;
    }
}