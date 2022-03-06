class Solution {
    public List<String> cellsInRange(String s) {
        List<String> ans=new ArrayList<>();
        int startRow=s.charAt(1)-'0',endRow=s.charAt(4)-'0';
        char startCol=s.charAt(0),endCol=s.charAt(3);
        for(int i=startRow;i<=endRow;i++){
            for(char x=startCol;x<=endCol;x++){
                ans.add(x+""+i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}