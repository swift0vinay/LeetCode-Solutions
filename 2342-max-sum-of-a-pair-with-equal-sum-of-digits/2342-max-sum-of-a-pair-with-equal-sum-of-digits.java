class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,PriorityQueue<Integer>> hm=new HashMap<>();
        int max=-1;
        for(int x:nums){
            int sum=0,z=x;
            while(z>0){
                sum+=z%10;
                z/=10;
            }
            if(hm.get(sum)==null){
                hm.put(sum,new PriorityQueue<Integer>());
            }
            hm.get(sum).add(x);
            while(hm.get(sum).size()>2){
                hm.get(sum).poll();
            }
            if(hm.get(sum).size()==2){
                z=0;
                for(Integer xx:hm.get(sum)){
                    z+=xx;
                }
                max=Integer.max(max,z);
            }
        }
        return max;
    }
}