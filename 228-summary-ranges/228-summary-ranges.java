class Solution {
    public List<String> summaryRanges(int[] ar) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<ar.length;){
            int j=i+1;
            for(;j<ar.length;j++){
                if(ar[j]-ar[j-1]!=1)
                    break;
            }
            int start=ar[i];
            int end= ar[j-1];
            if(start==end){
                ans.add(start+"");
            }else{
                ans.add(start+"->"+end);
            }
            i=j;
        }
        return ans;
    }
}