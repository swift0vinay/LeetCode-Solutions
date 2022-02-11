class Solution {
    public int[] constructRectangle(int area) {
        int l=Integer.MAX_VALUE,r=-1;
        for(int i=1;i<=(int)Math.sqrt(area);i++){
            if(area%i==0){
                int z=area/i;
                if(area%z==0){
                    if(z<l){
                        l=z;
                        r=i;
                    }
                }
            }
        }
        return new int[]{l,r};
    }
}