class Solution {
    public int countCollisions(String directions) {
        int ans=0;
        char ar[]=directions.toCharArray();
        ArrayDeque<Character> dq=new ArrayDeque<>();
        dq.add(ar[0]);
        for(int i=1;i<ar.length;i++){
            char x=dq.peekLast();
            if(x=='R' && ar[i]=='L'){
                dq.pollLast();
                ans+=2;
                while(!dq.isEmpty() && dq.peekLast()=='R'){
                    ans+=1;
                    dq.pollLast();
                }
                dq.add('S');
            }else if(x=='S' && ar[i]=='L'){
                dq.add('S');
                ans+=1;
            }else if(x=='R' && ar[i]=='S'){
                while(!dq.isEmpty() && dq.peekLast()=='R'){
                    ans+=1;
                    dq.pollLast();
                }
                dq.add('S');
            }else{
                dq.add(ar[i]);
            }
        }
        // System.out.println(dq);
        return ans;
    }
}