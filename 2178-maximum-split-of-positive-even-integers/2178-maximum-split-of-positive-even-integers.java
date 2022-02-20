class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        HashMap<Long,Long> hm=new HashMap<>();
        if(finalSum%2!=0)
            return new ArrayList<>();
        long key=-1;
        long max=0;
        for(long start=2;;start+=2){
            if(finalSum<=0)
                break;
            long z=Long.min(start,finalSum);
            finalSum-=z;
            hm.put(z,hm.getOrDefault(z,0L)+1L);
            max=Long.max(max,z);
            if(hm.get(z)>1){
                key=z;
            }
        }
        List<Long> ans=new ArrayList<>();
        for(Long z:hm.keySet()){
            if(key==-1){
                ans.add(z);
            }else{
                if(z==max){
                    ans.add(z+key);
                }else{
                    ans.add(z);
                }
            }
        }
        return ans;
    }
}