class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean A[]=new boolean[2001],B[]=new boolean[2001];
        for(int x:nums1) A[x+1000]=true;
        for(int x:nums2) B[x+1000]=true;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> a=new ArrayList<>(),b=new ArrayList<>();
        for(int i=0;i<2001;i++){
            if(A[i] && !B[i]){
                a.add(i-1000);
            }else if(B[i] && !A[i]){
                b.add(i-1000);
            }
        }
        ans.add(a);
        ans.add(b);
        return ans;
    }
}