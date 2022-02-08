class Solution {
    public int lastRemaining(int n) {
        if(n==1)
            return 1;
        n-=n%2;
        return n+2-2*lastRemaining(n/2);
    }
}