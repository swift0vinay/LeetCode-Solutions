class Solution {
    public int minJumps(int[] ar) {
        HashMap<Integer,ArrayDeque<Integer>> hm=new HashMap<>();
        int n=ar.length;
        if(n<=1)return 0;
        // ArrayList<HashSet<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=ar[i];
            if(hm.get(x)==null)
                hm.put(x,new ArrayDeque<>());
            hm.get(x).add(i);
        }
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        boolean visited[]=new boolean[n];
        int ans=0;
        dq.add(0);
        visited[0]=true;
        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){
                int k=dq.pollFirst();
                if(k==n-1)
                    return ans;
                while(!hm.get(ar[k]).isEmpty()){
                    int in=hm.get(ar[k]).pollFirst();
                    if(!visited[in]){
                        dq.add(in);
                        visited[in]=true;
                    }
                }
                if(k+1<n && !visited[k+1]){
                    dq.add(k+1);
                    visited[k+1]=true;
                }
                if(k-1>=0 && !visited[k-1]){
                    dq.add(k-1);
                    visited[k-1]=true;;
                }
            }
            ++ans;
        }
        return ans;
    }
}