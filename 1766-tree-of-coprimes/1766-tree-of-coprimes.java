class Solution {
    ArrayList<ArrayList<Integer>> al;
    int n;
    boolean[][] dp;
    boolean[] visited;
    int ans[];
    int max=-1;
    public int[] getCoprimes(int[] ar, int[][] ed) {
        al=new ArrayList<>();
        n=ar.length;
        dp=new boolean[51][51];
        ans=new int[n];
        fill();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<ed.length;i++){
            al.get(ed[i][0]).add(ed[i][1]);
            al.get(ed[i][1]).add(ed[i][0]);
        }
        Arrays.fill(ans,-1);
        for(int i=1;i<=50;i++){
            max=-1;
            visited=new boolean[n];
            dfs(0,i,max,ar);
        }
        return ans;
    }
    void dfs(int src,int val,int max,int[] ar){
        if(ar[src]==val){
            ans[src]=max;
        }
        if(dp[val][ar[src]]){
            max=src;
        }
        visited[src]=true;
        for(Integer z:al.get(src)){
            if(!visited[z]){
                dfs(z,val,max,ar);
            }
        }
    }
    void fill(){
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                if(gcd(i,j)==1){
                    dp[i][j]=true;
                }
            }
        }
    }
    
    int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}