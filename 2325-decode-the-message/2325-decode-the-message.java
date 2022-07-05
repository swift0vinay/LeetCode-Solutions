class Solution {
    public String decodeMessage(String key, String message) {
        boolean used[] = new boolean[26];
        char mk[] = new char[26];
        char mkk[] = new char[26];
        int ind=0;
        for(char x:key.toCharArray()) {
            if(x==' ')
                continue;
            if(used[x-'a']){
                continue;
            }else{
                mk[ind++] = x;
                used[x-'a'] = true;
            }
        }
        for (int i=0;i<26;i++) {
            mkk[mk[i]-'a']=(char)(i+'a');
        }
        System.out.println(Arrays.toString(mk));
        StringBuilder ans=new StringBuilder();
        for(char x:message.toCharArray()) {
            if(x==' '){
                ans.append(' ');
                continue;
            }
            ans.append(mkk[x-'a']);
        }
        return ans.toString();
    }
}