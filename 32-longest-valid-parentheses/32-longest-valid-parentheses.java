class Solution {
    public int longestValidParentheses(String s) {
        int l=0,r=0,max=0;
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x=='('){
                ++l;
            }else{
                ++r;
            }
            if(l==r){
                max=Integer.max(max,2*l);
            }else if(r>=l){
                l=r=0;
            }
        }
        l=r=0;
        for(int i=s.length()-1;i>=0;i--){
            char x=s.charAt(i);
            if(x=='('){
                ++l;
            }else if(x==')'){
                ++r;
            }
            if(l==r){
                max=Integer.max(max,2*l);
            }else if(l>=r){
                l=r=0;
            }
        }
        return max;
    }
}