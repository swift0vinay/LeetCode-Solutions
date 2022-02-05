class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> left=new ArrayList<>(),right=new ArrayList<>();
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot)
                ++c;
            else if(nums[i]<pivot)
                left.add(nums[i]);
            else
                right.add(nums[i]);
        }
        int ind=0;
        for(Integer z:left){
            nums[ind]=z;
            ++ind;
        }
        while(c>0){
            nums[ind]=pivot;
            --c;
            ++ind;
        }
        for(Integer z:right){
            nums[ind]=z;
            ++ind;
        }
        return nums;
    }
}