class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n=points.length;
        int ans[]=new int[n];
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<101;i++){
            al.add(new ArrayList<>());
        }
        for(int[] ar:rectangles){
            int l=ar[0],h=ar[1];
            al.get(h).add(l);
        }
        for(int i=1;i<=100;i++){
            Collections.sort(al.get(i));
        }
        for(int i=0;i<n;i++){
            int h=points[i][1],l=points[i][0];
            int ss=0;
            for(int j=h;j<=100;j++){
                ArrayList<Integer> temp=al.get(j);
                if(temp.size()==0)
                    continue;
                int ind=Collections.binarySearch(temp,l);
                if(ind<0){
                    ind=~ind;
                }
                ss+=temp.size()-ind;
            }
            ans[i]=ss;
        }
        return ans;
    }
}