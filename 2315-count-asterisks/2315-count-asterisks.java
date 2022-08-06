class Solution {
    public int countAsterisks(String s) {
        int count=0;
        int prev=-1;
        boolean isBar=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|'){
                if(prev==-1){
                    prev=i;
                    isBar=true;
                }else{
                    prev=-1;
                    isBar=false;
                }
            }
            if(!isBar && s.charAt(i)=='*'){
                ++count;
            }
        }
        return count;
    }
}