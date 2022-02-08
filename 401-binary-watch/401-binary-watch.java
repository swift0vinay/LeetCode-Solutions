class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans=new ArrayList<>();
        int ar[]={1,2,4,8,1,2,4,8,16,32};
        for(int i=(1<<ar.length)-1;i>=0;i--){
            char br[]=Integer.toBinaryString(i).toCharArray();
            if(Integer.bitCount(i)!=turnedOn)
                continue;
            int end=ar.length-1,end2=br.length-1;
            int hours=0,min=0;
            while(end>=0 && end2>=0){
                if(br[end2]=='1'){
                    if(end<=3){
                        hours+=ar[end];
                    }else{
                        min+=ar[end];
                    }
                }
                --end;
                --end2;
            }
            String h=hours+"";
            String m="0".repeat(2-(min+"").length())+min;
            if(hours>=0 && hours<=11 && min>=0 && min<60)
            ans.add(h+":"+m);
        }
        return ans;
    }
}