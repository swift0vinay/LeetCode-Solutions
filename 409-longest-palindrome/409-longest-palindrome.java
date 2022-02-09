class Solution {
    public int longestPalindrome(String s) {
        int[] ans=new int[256];
        for(char x:s.toCharArray()){
            ans[x]++;
        }
        int e=0,maxOdd=0;
        for(int x:ans){
            if(x%2==0){
                e+=x;
            }else{
                maxOdd=Integer.max(maxOdd,x);
            }
        }
        boolean done=false;
        for(int x:ans){
            if(x%2!=0){
                if(x==maxOdd && !done){
                    done=true;
                }else{
                    e+=x-1;
                }
            }
        }
        e+=maxOdd;
        return e;
    }
}