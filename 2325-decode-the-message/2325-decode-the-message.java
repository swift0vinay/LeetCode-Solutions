class Solution {
    public String decodeMessage(String key, String message) {
        boolean used[] = new boolean[26];
        char mk[] = new char[26];
        int ind=0;
        for(char x:key.toCharArray()) {
            if(x==' ')
                continue;
            if(used[x-'a']){
                continue;
            }else{
                mk[x-'a']=(char)(ind+'a');
                ++ind;
                used[x-'a'] = true;
            }
        }
        StringBuilder ans=new StringBuilder();
        for(char x:message.toCharArray()) {
            if(x==' '){
                ans.append(' ');
                continue;
            }
            ans.append(mk[x-'a']);
        }
        return ans.toString();
    }
}