class Encrypter {
    
    String dp[]=new String[26];
    HashMap<String,Integer> hm=new HashMap<>();
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for(int i=0;i<keys.length;i++){
            int index=keys[i]-'a';
            String val=values[i];
            dp[index]=val;
        }
        for(String s:dictionary){
            String get=encrypt(s);
            hm.put(get,hm.getOrDefault(get,0)+1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<word1.length();i++){
            ans.append(dp[word1.charAt(i)-'a']);
        }
        return ans.toString();
    }
    
    public int decrypt(String word2) {
        int ans=hm.getOrDefault(word2,0);
        return ans;
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */