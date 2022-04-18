class Solution {
    public int countSegments(String s) {
        String[] ar=s.split(" ");
        int c=0;
        for(String ss:ar){
            if(ss.trim().length()>0){
                ++c;
            }
        }
        return c;
    }
}