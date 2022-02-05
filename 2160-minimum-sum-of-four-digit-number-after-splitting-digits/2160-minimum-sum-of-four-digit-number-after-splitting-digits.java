class Solution {
    public int minimumSum(int num) {
        char ar[]=Integer.toString(num).toCharArray();
        Arrays.sort(ar);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<16;i++){
            String s=Integer.toBinaryString(i);
            while(s.length()!=4)
                s="0"+s;
            int a=0,b=0;
            char br[]=s.toCharArray();
            for(int ii=0;ii<4;ii++){
                if(br[ii]=='1')
                    a=a*10+(ar[ii]-'0');
                else
                    b=b*10+(ar[ii]-'0');
            }
            ans=Integer.min(a+b,ans);
        }
        return ans;
    }
}