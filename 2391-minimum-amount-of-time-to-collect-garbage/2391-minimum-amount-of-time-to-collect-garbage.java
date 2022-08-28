class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int last[] = new int[3];
        last[0]=last[1]=last[2]=-1;
        int ar[][] = new int[n][3];
        for(int i=n-1;i>=0;i--){
            for(char x : garbage[i].toCharArray()) {
                if(x=='G') {
                    ar[i][0]+=1;
                }else if(x=='P'){
                    ar[i][1]+=1;
                }else{
                    ar[i][2]+=1;
                }
            }
            for(int j=0;j<3;j++){
                if(ar[i][j]>0){
                    last[j] = Integer.max(last[j],i);
                }
            }
        }
        int total=0;
        for(int i=0;i<3;i++) {
            for(int j=0;j<=last[i];j++){
                if(j!=0)
                    total += travel[j-1];
                total += ar[j][i];
            }
        }
        return total;
    }
}