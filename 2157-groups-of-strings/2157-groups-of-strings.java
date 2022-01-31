class Solution {
    public int[] groupStrings(String[] ar) {
        int n=ar.length;
        
        HashSet<String> done=new HashSet<>();
        HashMap<String,int[]> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            char s[]=ar[i].toCharArray();
            Arrays.sort(s);
            ar[i]=String.valueOf(s);
            if(hm.get(ar[i])==null){
                hm.put(ar[i],new int[]{i,0});
            }
            hm.get(ar[i])[1]++;;
        }
        HashMap<String,Integer> hm2=new HashMap<>();
        ar=hm.keySet().stream().toArray(String[] ::new);
        n=ar.length;
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<Integer>());
        }
        // System.out.println(Arrays.toString(ar));
        for(int i=0;i<ar.length;i++){
            String s=ar[i];
            if(hm2.get(s)!=null){
                al.get(i).add(hm2.get(s));
                al.get(hm2.get(s)).add(i);
            }
            for(int j=0;j<s.length();j++){
                String z=s.substring(0,j)+s.substring(j+1);
                if(hm2.get(z)==null){
                    hm2.put(z,i);
                }else{
                    al.get(i).add(hm2.get(z));
                    al.get(hm2.get(z)).add(i);
                }
            }
             hm2.put(s,i);
        }
        // System.out.println(hm2+"\n"+al);
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            size=0;
            if(!vis[i]){
                ++total;
                dfs(ar,vis,al,i,hm);
            }
            max=Integer.max(max,size);
        }
        return new int[]{total,max};
    }
    String getString(int a,int b){
        return a+"-"+b;
    }
    void dfs(String[] ar,boolean[] vis,ArrayList<ArrayList<Integer>> al,int src,HashMap<String,int[]> hm){
        vis[src]=true;
        size+=hm.get(ar[src])[1];
        for(Integer z:al.get(src)){
            if(!vis[z]){
                dfs(ar,vis,al,z,hm);
            }
        }
    }
    int size=0;
    int total=0,max=0;
    String cS(boolean dp[]){
        String z="";
        for(char c='a';c<='z';c++){
            if(dp[c-'a'])
                z+=c;
        }
        return z;
    }
}