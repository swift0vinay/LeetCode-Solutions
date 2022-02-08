class Solution {
    public char findTheDifference(String s, String t) {
        char A[]=new char[26];
        char B[]=new char[26];
        for(char x:s.toCharArray()) A[x-'a']++;
        for(char x:t.toCharArray()) B[x-'a']++;
        for(int i=0;i<26;i++){
            if(A[i]!=B[i])
                return (char)(i+'a');
        }
        return ' ';
    }
}