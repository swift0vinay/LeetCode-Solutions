class Solution {
    public List<Integer> maxScoreIndices(int[] ar) {
        List<Integer> ans=new ArrayList<>();
        ArrayList<int[]> a1=new ArrayList<>(),a2=new ArrayList<>();
        int z=0,o=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]==0) ++z;
            else ++o;
            a1.add(new int[]{z,o});
        }
        int max=0;
        for(int i=0;i<=ar.length;i++){
             z=i-1>=0?a1.get(i-1)[0]:0;
             o=0;
             if(i<ar.length)
             o=a1.get(ar.length-1)[1]-(i-1>=0?a1.get(i-1)[1]:0);
             max=Integer.max(z+o,max);
        }
        for(int i=0;i<=ar.length;i++){
            z=i-1>=0?a1.get(i-1)[0]:0;
            o=0;
             if(i<ar.length)
                 o=a1.get(ar.length-1)[1]-(i-1>=0?a1.get(i-1)[1]:0);
             if(max==o+z)
                ans.add(i);
        }
        return ans;
    }
}