class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(hm.get(cards[i])==null){
                hm.put(cards[i],i);
            }else{
                min=Integer.min(min,i-hm.get(cards[i])+1);
                hm.put(cards[i],i);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}