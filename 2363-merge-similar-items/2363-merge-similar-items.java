class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] val= new int[1001];
        List<List<Integer>> ans=new ArrayList<>();
        for(int[] x : items1) { val[x[0]]+=x[1]; }
        for(int[] x : items2) { val[x[0]]+=x[1]; }
        for(int i=0;i<1001;i++){
            if(val[i]>0){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(val[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}