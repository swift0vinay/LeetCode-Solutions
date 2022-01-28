class Solution {
    public int largestComponentSize(int[] ar) {
        int pre[]=new int[(int)1e5+1];
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int x:ar)
            pre[x]=1;
        for(int i=0;i<=(int)1e5;i++)
          al.add(new ArrayList<>());
        for(int i=2;i<=(int)1e5;i++){
            int prev=-1;
            for(int j=i;j<=(int)1e5;j+=i){
                if(pre[j]==1){
                    if(prev==-1){
                        prev=j;
                        continue;
                    }else{
                        al.get(prev).add(j);
                        al.get(j).add(prev);
                        prev=j;
                    }
                }
            }
        }
        int counter=0;
        boolean visited[]=new boolean[(int)1e5+1];
        for(int i=0;i<visited.length;i++){
            if(pre[i]==1 && !visited[i]){
                c=0;
                dfs(i,al,visited);
                counter=Integer.max(counter,c);
            }
        }
        return counter;
    }
    int c=0;
    void dfs(int src,ArrayList<ArrayList<Integer>> al,boolean[] visited){
        visited[src]=true;
        ++c;
        for(Integer z:al.get(src)){
            if(!visited[z]){
                dfs(z,al,visited);
            }
        }
    }
}