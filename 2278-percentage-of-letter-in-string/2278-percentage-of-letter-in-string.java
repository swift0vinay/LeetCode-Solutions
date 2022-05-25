class Solution {
    public int percentageLetter(String s, char letter) {
        int total=0;
        for(char x:s.toCharArray()){
            if(x==letter) ++total;
        }
        int ans=total*100;
        return ans/s.length();
    }
}