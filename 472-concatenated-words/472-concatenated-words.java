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
    void setNode(char x,TrieNode node){
        list[x-'a']=node;
    }
    TrieNode getNode(char x){
        return list[x-'a'];
    }
}
class Trie{
    TrieNode root=new TrieNode();
    void insert(String s){
        TrieNode node=root;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(!node.containsKey(curr)){
                node.setNode(curr,new TrieNode());
            }
            node=node.getNode(curr);
        }
        node.end+=1;
    }
}
class Solution {
    Trie trie=new Trie();
    List<String> ans=new ArrayList<>();
    boolean vis[];
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for(String s:words) trie.insert(s);
        for(String s:words){
            vis=new boolean[s.length()];
            if(dfs(s,0,-1)){
                ans.add(s);
            }
        }
        return ans;
    }
    boolean dfs(String s,int index,int counter){
        TrieNode curr=trie.root;
        if(index==s.length() && counter>=1)
            return true;
        if(index==s.length())
            return false;
        if(vis[index])
            return false;
        vis[index]=true;
        while(index<s.length() &&   curr.containsKey(s.charAt(index))){
            curr=curr.getNode(s.charAt(index));
            if(curr.end>0){
                boolean ans=dfs(s,index+1,counter+1);
                if(ans)
                    return true;
            }
            ++index;
        }
        return false;
    }
}