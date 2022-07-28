class Solution {
    public char repeatedCharacter(String s) {
        boolean dp[] = new boolean[26];
        for(int i=0; i<s.length(); i++){
            if(!dp[s.charAt(i)-'a']){
                dp[s.charAt(i)-'a']=true;
            }else{
                return s.charAt(i);
            }
        }
        return ' ';
    }
}