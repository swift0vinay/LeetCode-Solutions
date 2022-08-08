class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max=0;
        Arrays.sort(special);
        int prev=bottom;
        if(bottom!=special[0]){
            max=Integer.max(max,special[0]-bottom);
        }
        if(top!=special[special.length-1]){
            max=Integer.max(max,top-special[special.length-1]);
        }
        for(int i=0;i<special.length-1;i++){
            max=Integer.max(max,special[i+1]-special[i]-1);
        }
        return max;
    }
}