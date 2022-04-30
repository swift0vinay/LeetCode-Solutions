class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans=0;
        for(String word:words){
            int length=word.length();
            if(length>s.length())
                continue;
            String sub=s.substring(0,length);
            if(sub.equals(word)){
                ++ans;
            }
        }
        return ans;
    }
}