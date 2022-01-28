class Solution {
    int MAX=(int)1e5+1;
    ArrayList<ArrayList<Integer>> al;
    ArrayList<Integer> primes=new ArrayList<Integer>();
    HashMap<Integer,ArrayList<Integer>> items;
    boolean is[]=new boolean[MAX];
    void seive(){
        Arrays.fill(is,true);
        is[0]=is[1]=false;
        for(int i=2;i*i<MAX;i++){
            if(is[i]){
                for(int j=i*i;j<MAX;j+=i){
                    is[j]=false;
                }
            }
        }
        for(int i=2;i<MAX;i++){
            if(is[i]) primes.add(i);
        }
    }
    void buildGraph(){
        for(int i=0;i<MAX;i++)
            al.add(new ArrayList<>());
        for(Integer z:primes){
            int prev=-1;
            for(int start=z;start<MAX;start+=z){
                if(items.get(start)!=null){
                    if(prev==-1){
                        prev=start;
                    }else{
                        al.get(prev).add(start);
                        al.get(start).add(prev);
                        prev=start;
                    }
                }
            }
        }
    }
    public boolean gcdSort(int[] ar) {
        al=new ArrayList<>();
        items=new HashMap<>();
        for(int i=0;i<ar.length;i++){
            if(items.get(ar[i])==null)
                items.put(ar[i],new ArrayList<>());
            items.get(ar[i]).add(i);
        }
        seive();
        buildGraph();
        boolean visited[]=new boolean[MAX];
        for(int i=2;i<MAX;i++){
            if(!visited[i] && items.get(i)!=null){
                ArrayList<Integer> allIndex=new ArrayList<>();
                ArrayList<Integer> elements=new ArrayList<>();
                dfs(i,allIndex,elements,visited);
                Collections.sort(elements);
                Collections.sort(allIndex);
                // System.out.println(elements+" "+allIndex);
                 int start=0;
                for(Integer z:elements){
                    int counter=items.get(z).size();
                    while(counter>0 && start<allIndex.size()){
                        int index=allIndex.get(start);
                        ar[index]=z;
                        --counter;
                        ++start;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(ar));
        for(int i=1;i<ar.length;i++){
            if(ar[i-1]>ar[i])
                return false;
        }
        return true;
    }
    void dfs(int src,ArrayList<Integer> allIndex,ArrayList<Integer> elements,boolean[] visited){
        visited[src]=true;
        allIndex.addAll(items.get(src));
        elements.add(src);
        for(Integer z:al.get(src)){
            if(!visited[z]){
                dfs(z,allIndex,elements,visited);
            }
        }
    }
}