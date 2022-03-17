class Solution {
    public int scoreOfParentheses(String s) {
        int ar[]=new int[s.length()];
        for(int i=0;i<ar.length;i++){
            if(s.charAt(i)=='('){
                ar[i]=-1;
            }else{
                ar[i]=0;
            }
        }
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        // System.out.println(Arrays.toString(ar));
        for(int z:ar){
            if(z==0){
                 int val=0;
                 while(dq.peekLast()!=-1){
                     val+=dq.pollLast();
                 }
                 dq.pollLast();
                 if(val==0){
                     dq.add(1);
                 }else{
                     dq.add(2*val);
                 }
            }else{
                dq.add(z);
            }
        }
        int ans=0;
        while(!dq.isEmpty()){
            ans+=dq.pollLast();
        }
        return ans;
    }
}