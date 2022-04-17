class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans=0;
        int maxPen = total/cost1;
        for(int pen=0;pen<=maxPen;pen++){
            int penCost = pen*cost1;
            int left = total-penCost;
            ans+=1;
            if(left>0){
                ans+=(long)(left/cost2);
            }
        }
        return ans;
    }
}