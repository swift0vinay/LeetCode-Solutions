class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        if (k==0) {
            if (num % 10 ==0 ){
                return 1;
            }
            return -1;
        }
        int x = k, i = 1;
        while(x<=num) {
            if(x%10 == num%10) {
                return i;
            }
            i+=1;
            x = k*i;
        }
        return -1;        
    }
}