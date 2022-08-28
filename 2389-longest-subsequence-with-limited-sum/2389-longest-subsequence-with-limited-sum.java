class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            boolean s=false;
            for(int j=0;j<nums.length;j++){
                sum+=nums[j];
                if(sum>queries[i]){
                    ans[i]=j;
                    s=true;
                    break;
                }
            }
            if(!s && sum<=queries[i]){
                ans[i]= nums.length;
            }
        }
        return ans;
    }
}