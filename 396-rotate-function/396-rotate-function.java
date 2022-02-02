class Solution {
    public int maxRotateFunction(int[] ar) {
        int sum=0;
        for(int i:ar) 
            sum += i;
        int max=0;
        for(int i=0;i<ar.length;i++)
            max += i*ar[i];
        int prev=max;
        for(int i=ar.length-1;i>=1;i--){
            sum -= ar[i];
            int curr = prev+sum-(ar.length-1)*ar[i];
            max = Integer.max(max,curr);
            prev = curr;
            sum += ar[i];
        }
        return max;
    }
}