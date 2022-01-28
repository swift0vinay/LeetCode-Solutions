class Solution {
    public int numSimilarGroups(String[] ar) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();   
        int n=ar.length;
        for(int i=0;i<n;i++) al.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(check(ar[i].toCharArray(),ar[j].toCharArray())){
                    al.get(i).add(j);
                    al.get(j).add(i);
                }
            }
        }
        // System.out.println(al);
        boolean visited[]=new boolean[n];
        // System.out.println(Arrays.toString(visited));
        int counter=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(al,visited,i);
                ++counter;
            }
        }
        // System.out.println(Arrays.toString(visited));
        return counter;
    }
    void dfs(ArrayList<ArrayList<Integer>> al,boolean[] visited,int src){
        visited[src]=true;
        for(Integer z:al.get(src)){
            if(!visited[z])
                dfs(al,visited,z);
        }
    }
    boolean check(char a[],char b[]){
        int s=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])
                ++s;
        }
        return s==0||s==2?true:false;
    }
}