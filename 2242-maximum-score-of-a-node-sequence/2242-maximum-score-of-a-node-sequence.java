class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        ArrayList<PriorityQueue<Integer>> al=new ArrayList<>();
        int n=scores.length;
        for(int i=0;i<n;i++){
            al.add(new PriorityQueue<>((a,b)->scores[a]-scores[b]));
        }
        
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0],y=edges[i][1];
            al.get(x).add(y);
            al.get(y).add(x);
            while(al.get(x).size()>3){
                al.get(x).poll();
            }
            while(al.get(y).size()>3){
                al.get(y).poll();
            }
        }
        
        int ans=0;
        
        for(int[] ar:edges){
            int x=ar[0],y=ar[1];
            int curr=scores[x]+scores[y];
            for(Integer z : al.get(x)){
                for(Integer zz : al.get(y)){
                    HashSet<Integer> ss=new HashSet<>();
                    ss.addAll(Arrays.asList(new Integer[]{x,y,z,zz}));
                    if(ss.size()==4){
                        ans=Integer.max(ans,curr+scores[z]+scores[zz]);
                    }
                }
            }
        }
        
        return ans==0?-1:ans;
    }
}