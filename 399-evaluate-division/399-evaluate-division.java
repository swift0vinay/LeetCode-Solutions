class Solution {
    public double[] calcEquation(List<List<String>> eqn, double[] values, List<List<String>> Q) {
        HashMap<String,ArrayList<Edge>> hm=new HashMap<>();
        int n=eqn.size();
        for(int i=0;i<n;i++){
            String a=eqn.get(i).get(0);
            String b=eqn.get(i).get(1);
            if(hm.get(a)==null)
                hm.put(a,new ArrayList<>());
            if(hm.get(b)==null)
                hm.put(b,new ArrayList<>());
            hm.get(a).add(new Edge(b,values[i]));
            hm.get(b).add(new Edge(a,1/values[i]));
        }
        double[] ans=new double[Q.size()];
        for(int q=0;q<Q.size();q++){
            String a=Q.get(q).get(0);
            String b=Q.get(q).get(1);
            if(hm.get(a)==null || hm.get(b)==null)
            {
                ans[q]=-1.0;
                continue;
            }
            if(a.equals(b)){
                ans[q]=1.0;
                continue;
            }
            answerFound=false;
            HashSet<String> visited=new HashSet<>();
            double val=dfs(a,b,visited,hm,1.0);
            if(answerFound){
                ans[q]=val;
            }else{
                ans[q]=-1.0;
            }
        }
        return ans;
    }
    double dfs(String a,String b,HashSet<String> visited,HashMap<String,ArrayList<Edge>> hm,double curr){
        visited.add(a); 
        if(a.equals(b))
        {
            answerFound=true;
            return curr;
        }
        for(Edge z:hm.get(a)){
            if(!visited.contains(z.dest)){   
                double ans=dfs(z.dest,b,visited,hm,(curr*z.weight));
                if(answerFound){
                    curr=ans;
                    break;
                }   
            }
        }
        return curr;
    }
    boolean answerFound=false;
     class Edge{
        String dest;
        double weight;
        Edge(String dest,double weight){
            this.dest=dest;
            this.weight=weight;
        }
    }
}