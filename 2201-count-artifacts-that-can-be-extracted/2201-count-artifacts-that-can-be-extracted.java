class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean ar[][]=new boolean[n][n];
        for(int[] x:dig){
            int a=x[0],b=x[1];
            ar[a][b]=true;
        }
        int counter=0;
        for(int[] ss:artifacts){
            boolean rs=true;
            int a=ss[0],b=ss[1],c=ss[2],d=ss[3];
            for(int i=a;i<=c;i++){
                for(int j=b;j<=d;j++){
                    rs&=ar[i][j];
                }
            }
            if(rs){
                ++counter;
            }
        }
        return counter;
    }
}