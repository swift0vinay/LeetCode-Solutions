class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> al=new ArrayList<>();
        al.add(new ArrayList<>());
        al.get(0).add(1);
        for(int rows=2;rows<=numRows;rows++){
            ArrayList<Integer> ar=new ArrayList<Integer>();
            List<Integer> ar2=al.get(rows-2);
            ar.add(ar2.get(0));
            for(int i=1;i<ar2.size();i++){
                ar.add(ar2.get(i)+ar2.get(i-1));
            }
            ar.add(ar2.get(ar2.size()-1));
            al.add(ar);
        }
        return al;
    }
}