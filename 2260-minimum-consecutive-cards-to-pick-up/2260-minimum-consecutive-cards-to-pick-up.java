class Solution {
    public int minimumCardPickup(int[] cards) {
        int last[]= new int[(int)1e6+1];
        for(int i=0;i<(int)1e6+1;i++){
            last[i] = -1;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(last[cards[i]]==-1){
                last[cards[i]]=i;
            }else{
                min=Integer.min(min,i-last[cards[i]]+1);
                last[cards[i]]=i;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}