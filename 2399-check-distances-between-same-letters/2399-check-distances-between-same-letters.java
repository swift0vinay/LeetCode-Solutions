class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for(int j=0;j<26;j++){
            int last=-1;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)-'a'==j){
                    if(last==-1){
                        last=i;
                    }else{
                        if(i-last-1!=distance[j]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}