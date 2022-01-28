class Solution {
    public String longestPrefix(String s) {
        if(s.length()<2)
            return "";
        int lps[] = createLps(s,s.length());
        int m=s.length();
        int z=lps[m-1];
        return s.substring(0,z);
    }
    
    int[] createLps(String s,int m){
        int[] lps=new int[m];
        int length=0,curr=1;
        while(curr<m){
            if(s.charAt(length)==s.charAt(curr)){
                ++length;
                lps[curr]=length;
                ++curr;
            }else{
                if(length==0) ++curr;
                else length=lps[length-1];
            }
        }
        return lps;
    }
}