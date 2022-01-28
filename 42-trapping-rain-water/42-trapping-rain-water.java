class Solution {
    public int trap(int[] ar) {
        int n=ar.length,ans=0;
        int left[]=new int[n],right[]=new int[n];
        int MAX=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            right[i]=MAX;
            left[i]=MAX;
        }
        int max=ar[0];
        for(int i=1;i<n;i++){
            if(max<ar[i]){
                max=ar[i];
            }else{
                left[i]=max;
            }
        }
        max=ar[n-1];
        for(int i=n-2;i>=0;i--){
            if(max<ar[i]){
                max=ar[i];
            }else{
                right[i]=max;
            }
        }
        for(int i=0;i<n;i++){
            if(left[i]==MAX||right[i]==MAX) continue;
            ans+=Integer.min(left[i],right[i])-ar[i];
        }
        return ans;
    }
}