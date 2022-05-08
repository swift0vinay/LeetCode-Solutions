class Solution {
    public String largestGoodInteger(String num) {
        for(char c='9';c>='0';c--){
            for(int i=0;i+2<num.length();i++){
                char a= num.charAt(i),b=num.charAt(i+1),cc=num.charAt(i+2);
                if(a==c && b==c && cc==c){
                    return c+""+c+""+c;
                }
            }
        }
        return "";
    }
}