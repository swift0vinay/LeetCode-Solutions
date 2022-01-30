class Solution {
    public int findFinalValue(int[] ar, int X) {
        Arrays.sort(ar);
        while(Arrays.binarySearch(ar,X)>=0){
            X*=2;
        }
        return X;
    }
}