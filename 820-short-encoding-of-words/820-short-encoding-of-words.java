class Solution {
    class TrieNode{
        TrieNode list[];
        boolean end;
        
        TrieNode(){
            list=new TrieNode[26];
            end=false;
        }
        
        boolean contains(char x){
            return list[x-'a']==null?false:true;
        }
        
    }
    
    class Trie{
        TrieNode root=new TrieNode();
        void insert(String s){
            TrieNode curr=root;
            for(int i=s.length()-1;i>=0;i--){
                char ch=s.charAt(i);
                if(!curr.contains(ch)){
                    curr.list[ch-'a']=new TrieNode();   
                }
                curr=curr.list[ch-'a'];
            }
            curr.end=true;
        }
        int ans=0;
        int create(){
            for(int i=0;i<26;i++){
                if(root.list[i]!=null)
                    dfs((char)(i+'a')+"",root.list[i]);
            }
            return ans;
        }
        
        void dfs(String ss,TrieNode node){
            boolean isNodeEnd=node.end;
            boolean rs=false;
            for(int i=0;i<26;i++){
                if(node.list[i]!=null){
                    dfs(ss+(char)(i+'a'),node.list[i]);
                    rs=true;
                }
            }
            if(!rs && isNodeEnd && ss.length()>0){
                ans+=ss.length()+1;
            }
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Trie trie=new Trie();
        for(String s:words){
            trie.insert(s);
        }
        return trie.create();
    }
}