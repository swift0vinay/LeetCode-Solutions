class Solution {
    public int maximumRows(int[][] ar, int N) {
        int n=ar.length, m = ar[0].length;
        int max=0;
        for(int i=1;i<(1<<m);i++){
            if(Integer.bitCount(i)==N){
                ArrayList<Integer> al = new ArrayList<>();
                for(int j=0;j<12;j++){
                    int z = i>>j;
                    if((z&1) == 1){
                        al.add(j);
                    }
                }
                int row=0;
                for(int j=0;j<n;j++){
                    boolean allZero=true;
                    boolean oneValid=true;
                    for(int k=0;k<m;k++){
                        if(ar[j][k]==1){
                            allZero=false;
                            if(!al.contains(k)){
                                oneValid=false;
                                break;
                            }
                        }
                    }
                    if(oneValid||allZero){
                        ++row;
                    }
                }
                max=Integer.max(max,row);
            }
        }
        return max;
    }
}