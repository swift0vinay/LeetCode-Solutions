class Solution {
    public int wiggleMaxLength(int[] ar) {
        int n=ar.length;
        if(n<2) return n;
        int up=1,down=1;
        for(int i=1;i<n;i++){
            if(ar[i]>ar[i-1]){
                up=down+1;
            }else if(ar[i-1]>ar[i]){
                down=up+1;
            }
        }
        return Integer.max(up,down);
    }
}