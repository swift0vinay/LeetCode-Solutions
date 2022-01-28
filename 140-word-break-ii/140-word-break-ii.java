class TrieNode{
    int end;
    TrieNode list[];
    TrieNode(){
        this.end=0;
        this.list=new TrieNode[26];
    }
    
    boolean containsKey(char x){
        return list[x-'a']!=null;
    }
    
    TrieNode getNode(char x){
        return list[x-'a'];
    }
    
    void putNode(char x,TrieNode node){
        list[x-'a']=node;
    }
}
class Trie{
    TrieNode root=new TrieNode();
    void insert(String s){
        TrieNode node=root;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(!node.containsKey(curr))
                node.putNode(curr,new TrieNode());
            node=node.getNode(curr);
        }
        node.end++;
    }
}
class Solution {
    Trie trie=new Trie();
    List<String> list=new ArrayList<>();
    boolean vis[];
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word:wordDict) trie.insert(word);
        vis=new boolean[s.length()];
        dfs(s,0);
        return list;
    }
    ArrayDeque<String> dq=new ArrayDeque<>();
    void dfs(String s,int index){
        if(index==s.length()){
            StringBuilder ss=new StringBuilder();
            for(String k:dq) ss.append(k+" ");
            ss.deleteCharAt(ss.length()-1);
            list.add(ss.toString());
            return;
        }
        if(vis[index]){
            return;
        }
        TrieNode curr=trie.root;
        vis[index]=true;
        String tt="";
        int in=index;
        while(index<s.length() && curr.containsKey(s.charAt(index))){
            curr=curr.getNode(s.charAt(index));
            tt+=s.charAt(index);
            if(curr.end>0){
                dq.add(tt);
                dfs(s,index+1);
                dq.pollLast();
            }
            ++index;
        }
        vis[in]=false;
    }
}