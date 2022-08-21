class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int ans=0;
        char ar[]=s.toCharArray();
        while(true){
            boolean rs=false;
            char ar2[]=Arrays.copyOf(ar,ar.length);
            for(int i=0;i<ar.length;i++){
                if(ar[i]=='1' && i-1>=0 && ar[i-1]=='0'){
                    ar2[i]='0';
                    ar2[i-1]='1';
                    rs=true;
                }
            }
            if(!rs)
                break;
            ar=ar2;
            ++ans;
        }
        return ans;
    }
}