class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int n=text.length();
        long a[]=new long[n],b[]=new long[n];
        long aa=0,bb=0;
        for(int i=0;i<n;i++){
            if(text.charAt(i)==pattern.charAt(0)){
                ++aa;
            }
            if(text.charAt(i)==pattern.charAt(1)){
                ++bb;
            }
            a[i]=aa;
            b[i]=bb;            
        }
        long max=0;
        for(int i=0;i<n;i++){
            if(text.charAt(i)==pattern.charAt(0)){
                max+=b[n-1]-b[i];
            }
        }
        max+=Long.max(a[n-1],b[n-1]);
        return max;
    }
}