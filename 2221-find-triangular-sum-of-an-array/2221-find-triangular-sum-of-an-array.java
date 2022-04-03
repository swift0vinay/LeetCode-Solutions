class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length==1)
            return nums[0];
        ArrayDeque<Integer> dq=new ArrayDeque<>(),dq2=new ArrayDeque<>();
        for(int x:nums) dq.add(x);
        for(int times=0;times<nums.length-1;times++){
            while(dq.size()>1){
                int a=dq.pollFirst();
                dq2.add((a+dq.peekFirst())%10);
            }
            dq.pollFirst();
            dq.addAll(dq2);
            dq2.clear();
        }
        return dq.pollFirst();
    }
}