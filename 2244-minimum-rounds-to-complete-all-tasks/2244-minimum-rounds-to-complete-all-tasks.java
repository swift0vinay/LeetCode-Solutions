class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x:tasks){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int ans=0;
        for(Integer z:hm.keySet()){
            int c=hm.get(z);
            if(c%3==0){
                ans+=c/3;
                continue;
            }else if((c-2)>0 && (c-2)%3==0){
                ans+=1;
                ans+=(c-2)/3;
                continue;
            }else if((c-4)>0 && (c-4)%3==0){
                ans+=2;
                ans+=(c-4)/3;
                continue;
            }else if(c%2==0){
                ans+=c/2;
                continue;
            }else{
                return -1;
            }
        }
        return ans;
    }
}