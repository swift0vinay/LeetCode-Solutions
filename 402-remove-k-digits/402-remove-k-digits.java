class Solution {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> dq=new ArrayDeque<>();
        for(int i=0;i<num.length();i++){
            while(!dq.isEmpty() && k>0 &&  dq.peekLast()>num.charAt(i)){
                    dq.pollLast();
                    --k;
            }
            if(!dq.isEmpty() || num.charAt(i)!='0'){
                dq.add(num.charAt(i));
            }
        }

        while(!dq.isEmpty() && k>0){
            dq.pollLast();
            --k;
        }
        
        if(dq.isEmpty())
            return "0";
        StringBuilder ans=new StringBuilder();
        while(!dq.isEmpty()){
            ans.append(dq.pollFirst());
        }
        return ans.toString();
    }
}