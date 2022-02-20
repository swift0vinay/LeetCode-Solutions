class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        HashMap<Long,Long> hm=new HashMap<>();
        if(finalSum%2!=0)
            return new ArrayList<>();
        long key=-1;
        for(long start=2;;start+=2){
            if(finalSum<=0)
                break;
            long z=Long.min(start,finalSum);
            finalSum-=z;
            hm.put(z,hm.getOrDefault(z,0L)+1L);
            if(hm.get(z)>1){
                key=z;
            }
        }
        List<Long> ans=new ArrayList<>();
        for(Long z:hm.keySet())
            ans.add(z);
        Collections.sort(ans);
        if(key!=-1){
            ans.set(ans.size()-1,ans.get(ans.size()-1)+key);
        }
        return ans;
    }
}