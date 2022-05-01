class Solution {
    public String removeDigit(String number, char digit) {
        char ar[]=number.toCharArray();
        for(int i=0;i+1<ar.length;i++){
            if(ar[i]==digit && ar[i]<ar[i+1]){
                String left=number.substring(0,i);
                String right=number.substring(i+1);
                return left+right;
            }
        }
        for(int i=ar.length-1;i>=0;i--){
            if(ar[i]==digit){
                String left=number.substring(0,i);
                String right=number.substring(i+1);
                return left+right;
            }
        }
        return "";
    }
}