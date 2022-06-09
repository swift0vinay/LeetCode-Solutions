class Solution {
    public int minMaxGame(int[] nums) {
        while(nums.length>1){
            int x[]=new int[nums.length/2];
            for(int i=0;i<x.length;i++){
                if(i%2==0)
                    x[i]=Integer.min(nums[2*i], nums[2*i+1]);
                else
                    x[i]=Integer.max(nums[2*i], nums[2*i+1]);
            }
            nums=Arrays.copyOf(x,x.length);
        }
        return nums[0];
    }
}