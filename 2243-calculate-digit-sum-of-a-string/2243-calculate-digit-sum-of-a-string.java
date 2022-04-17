class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder zz=new StringBuilder();
            int sum=0,c=0;
            for(int i=0;i<s.length();i++){
                ++c;
                sum+=(s.charAt(i)-'0');
                if(c==k){
                    c=0;
                    zz.append(sum);
                    sum=0;
                }
            }
            if(c>0){
                zz.append(sum);
            }
            s=new String(zz.toString());
        }
        return s;
    }
}