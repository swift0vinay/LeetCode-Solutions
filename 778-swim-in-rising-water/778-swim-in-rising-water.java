class Solution {
    int n,m;
    boolean[][] visited;
    public int swimInWater(int[][] ar) {
        int min=0,max=0;
        n=ar.length;
        m=ar[0].length;
        for(int x[]:ar)
            for(int y:x)
                max=Integer.max(max,y);
        int ans=Integer.MAX_VALUE;
        while(min<=max){
            int mid=(min+max)/2;
            visited=new boolean[n][m];
            found=false;
            dfs(0,0,ar,mid);
            // System.out.println(mid+" "+found);
            if(found){
                ans=Integer.min(mid,ans);
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return ans;
    }
    boolean found=false;
    void dfs(int i,int j,int[][] ar,int mid){
        if(i<0||j<0||i>=n||j>=m||visited[i][j]||ar[i][j]>mid)
            return;
        if(i==n-1 && j==m-1){
            found=true;
            return;
        }
        visited[i][j]=true;
        if(!found)
            dfs(i-1,j,ar,mid);
        if(!found)
            dfs(i+1,j,ar,mid);
        if(!found)
            dfs(i,j-1,ar,mid);
        if(!found)
            dfs(i,j+1,ar,mid);
    }
}