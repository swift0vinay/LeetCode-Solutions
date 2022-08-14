class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        int ar[]=new int[n+1];
        ar[0]=1;
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)=='I'){
                for(int j=ar[i]+1;j<=9;j++){
                    boolean rs=true;
                    for(int k=i;k>=0;k--){
                        if(ar[k]==j){
                            rs=false;
                            break;
                        }
                    }
                    if(rs){
                        ar[i+1]=j;
                        break;
                    }
                }
            }else{
                int arrayIndex = i;
                for(;arrayIndex>=0;arrayIndex--){
                    ar[arrayIndex]+=1;
                    if(arrayIndex>0 && pattern.charAt(arrayIndex-1)=='D'){
                        continue;
                    }else{
                        break;
                    }
                }
                ar[i+1]=ar[i]-1;
            }
        }
        StringBuilder ss=new StringBuilder();
        for(int x : ar) ss.append(x);
        return ss.toString();
    }
}