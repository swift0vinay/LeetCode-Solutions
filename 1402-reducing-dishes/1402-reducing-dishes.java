class Solution {
    public int maxSatisfaction(int[] ar) {
        int n=ar.length;
        Arrays.sort(ar);
        int max=0;
        int prev=0;
        for(int i=n-1;i>=0;i--){
            if(max+ar[i]+prev>max){
               max+=ar[i]+prev;
            }
            prev+=ar[i];
        }
        return max;
    }
}