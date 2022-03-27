class Solution {
    public int minDeletion(int[] nums) {
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int x:nums){
            if(dq.isEmpty()){
                dq.add(x);
            }else if(dq.size()%2==0){
                dq.add(x);
            }else if(dq.size()%2!=0 && dq.peekLast()==x){
                continue;
            }else{
                dq.add(x);
            }
            // System.out.println(dq);
        }
        if(dq.size()%2!=0)
            dq.pollLast();
        return nums.length-dq.size();
    }
}