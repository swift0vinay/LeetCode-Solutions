class Solution {
    public int countEven(int num) {
        int ans=0;
        for(int start=2;start<=num;start++){
            int i=start,s=0;
            while(i>0){
                s+=i%10;
                i/=10;
            }
            ans+=(1^(s%2));
        }
        return ans;
    }
}