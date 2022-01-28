class Solution {
    public int maxSum(int[] ar, int[] br) {
        long sumA=0,sumB=0;
        int startA=0,startB=0;
        int n=ar.length,m=br.length;
        while(startA<n && startB<m){
            if(ar[startA]==br[startB]){
                long max=Long.max(sumA,sumB);
                sumA=max+ar[startA];
                sumB=max+br[startB];
                ++startA;
                ++startB;
            }else if(ar[startA]<br[startB]){
                sumA+=ar[startA];
                ++startA;
            }else {
                sumB+=br[startB];
                ++startB;
            }
        }
        while(startA<n){
            sumA+=ar[startA];
            ++startA;
        }
        while(startB<m){
            sumB+=br[startB];
            ++startB;
        }
        int INF=(int)1e9+7;
        return (int)(Long.max(sumA,sumB)%INF);
    }
}