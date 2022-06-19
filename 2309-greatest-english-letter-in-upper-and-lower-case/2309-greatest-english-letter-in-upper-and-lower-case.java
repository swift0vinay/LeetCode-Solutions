class Solution {
    public String greatestLetter(String s) {
       int dp[][]=new int[2][26];
       for(char x : s.toCharArray()) {
           if(Character.isUpperCase(x)){
               dp[1][Character.toLowerCase(x)-'a'] = 1;
           }else{
               dp[0][x-'a'] = 1;
           }
       }
       char ans = '-';
       for(int i=0;i<26;i++){
           if (dp[0][i] == 1 && dp[1][i] == 1) {
               ans=Character.toUpperCase((char)(i+'a'));
           }
       }
       return ans=='-'?"":(ans+"");
    }
}