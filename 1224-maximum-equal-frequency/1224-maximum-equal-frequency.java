class Solution {
    public int maxEqualFreq(int[] ar) {
        HashMap<Integer,Integer> hm=new HashMap<>(),freq=new HashMap<>();
        int max=0;
        for(int i=0;i<ar.length;i++){
            hm.put(ar[i],hm.getOrDefault(ar[i],0)+1);
            int curr=hm.get(ar[i]);
            freq.put(curr,freq.getOrDefault(curr,0)+1);
            int count=freq.get(curr)*curr;
            if(count==i+1 && i!=ar.length-1){
                max=Integer.max(max,i+2);
            }else if(count==i){
                max=Integer.max(max,i+1);
            }
        }
        return max;
    }
}