class Solution {
    public long smallestNumber(long num) {
        if(num==0)
            return 0;
        char[] ar;
        if(num>0){
            ar=Long.toString(num).toCharArray();
            Arrays.sort(ar);
            if(ar[0]=='0'){
                for(int i=0;i<ar.length;i++){
                    if(ar[i]!='0'){
                        ar[0]=ar[i];
                        ar[i]='0';
                        break;
                    }
                }
            }
        }else{
            ar=Long.toString(num).substring(1).toCharArray();
            Arrays.sort(ar);
            int start=0,end=ar.length-1;
            while(start<=end){
                char t=ar[start];
                ar[start]=ar[end];
                ar[end]=t;
                ++start;
                --end;
            }
            ar=("-"+String.valueOf(ar)).toCharArray();
        }
        return Long.parseLong(String.valueOf(ar));
    }
}