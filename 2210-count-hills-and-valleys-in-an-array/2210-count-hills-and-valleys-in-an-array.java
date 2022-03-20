class Solution {
    public int countHillValley(int[] ar) {
        int c=0;
        for(int i=1;i<ar.length-1;i++){
            int left=i-1,right=i+1;
            while(left>=0 && ar[left]==ar[i]){
                --left;
            }
            while(right<ar.length && ar[right]==ar[i]){
                ++right;
            }
            // System.out.println(i+" "+ar[i]+" "+left+" "+right);
            if(left>=0 && right<ar.length){
                if((ar[i]>ar[left] && ar[i]>ar[right])||(ar[i]<ar[left] && ar[i]<ar[right]) )
                {
                    if(ar[i]!=ar[i-1])
                        ++c;
                }
            }
        }
        return c;
    }
}