class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans=Integer.MAX_VALUE;
        char ar[]=blocks.toCharArray();
        int n=ar.length;
        for(int i=0;i<n;i++){
            int c=0,b=0;
            for(int j=i;j<n;j++){
                if(ar[j]=='B'){
                    ++b;
                }else{
                    ++b;
                    ++c;
                }
                if(b==k){
                    break;
                }
            }
            if(b==k){
                ans=Integer.min(ans,c);
            }
        }
        return ans;
    }
}