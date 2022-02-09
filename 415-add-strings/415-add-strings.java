class Solution {
    public String addStrings(String num1, String num2) {
        num1="0".repeat(Integer.max(0,num2.length()-num1.length()))+num1;
        num2="0".repeat(Integer.max(0,num1.length()-num2.length()))+num2;
        char ans[]=new char[num1.length()];
        // System.out.println(num1+"\n"+num2);
        Arrays.fill(ans,'0');
        int c=0;
        for(int i=num1.length()-1;i>=0;i--){
            int sum=num1.charAt(i)-'0'+num2.charAt(i)-'0'+c;
            ans[i]=(char)(sum%10+'0');
            c=sum/10;
        }
        if(c>0)
            return c+String.valueOf(ans);
        return String.valueOf(ans);
    }
}