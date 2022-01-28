class Solution {
    String[] a={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] b={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] c={"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int i=0;
        String ans="";
        while(num>0){
            if(num%1000!=0){
                String z=get(num%1000);
                ans=z+c[i]+" "+ans;   
            }
            ++i;
            num/=1000;
        }
        return ans.trim();
    }
    String get(int num){
        if(num<=0)
            return "";
        if(num<20)
            return a[num]+" ";
        if(num<100)
            return b[num/10]+" "+get(num%10);
        return a[num/100]+" Hundred "+get(num%100);
    }
}