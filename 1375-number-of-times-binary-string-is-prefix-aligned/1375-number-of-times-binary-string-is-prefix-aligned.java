class Solution {
    public int numTimesAllBlue(int[] l) {
        int ans=0,max=0;
        for(int i=0;i<l.length;i++){
            max=Integer.max(max,l[i]);
            if(max==i+1)
                ++ans;
        }
        return ans;
    }
}