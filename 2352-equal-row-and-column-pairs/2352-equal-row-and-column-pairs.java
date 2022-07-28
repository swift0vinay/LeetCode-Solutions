class Solution {
    public int equalPairs(int[][] ar) {
        int ans = 0;
        int n = ar.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int a=0,b=0;
                boolean rs=true;
                for(int k=0;k<n;k++){
                    if(ar[i][k] != ar[k][j]){
                        rs=false;
                        break;
                    }
                    ++a;
                    ++b;
                }
                if(rs)
                    ++ans;
            }
        }
        return ans;
    }
}