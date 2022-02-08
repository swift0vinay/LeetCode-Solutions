class TrieNode{
    TrieNode list[];
    TrieNode(){
        this.list=new TrieNode[10];
    }
    boolean containsKey(int x){
        return list[x]!=null;
    }
    void setNode(int x,TrieNode node){
        this.list[x]=node;
    }
    TrieNode getNode(int x){
        return list[x];
    }
}
class Trie{
    TrieNode root=new TrieNode();
    void insert(int x){
        TrieNode curr=root;
        ArrayList<Integer> al=new ArrayList<>();
        while(x>0){
            al.add(x%10);
            x/=10;
        }
        for(int i=al.size()-1;i>=0;i--){
            if(!curr.containsKey(al.get(i))){
                curr.setNode(al.get(i),new TrieNode());
            }
            curr=curr.getNode(al.get(i));
        }
    }
}
class Solution {
    Trie trie=new Trie();
    List<Integer> ans=new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<=n;i++){
            trie.insert(i);
        }
        dfs(trie.root,0);
        return ans;
    }
    void dfs(TrieNode root,int curr){
       if(curr!=0)
            ans.add(curr);
       for(int i=0;i<10;i++){
           if(root.list[i]!=null)
             dfs(root.list[i],(curr*10)+i);
       }
    }
}