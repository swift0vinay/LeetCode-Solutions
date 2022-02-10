class Solution {
    public boolean find132pattern(int[] ar) {
        int n=ar.length;
        int left[]=new int[n];
        left[0]=ar[0];
        for(int i=1;i<ar.length;i++){
            left[i]=Math.min(left[i-1], ar[i]);
        }
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            if(left[i]<ar[i]){
                while(!dq.isEmpty() && left[i]>=dq.peekLast()){
                    dq.pollLast();
                }
                if(!dq.isEmpty() && ar[i]>dq.peekLast()){
                    return true;
                }
                dq.add(ar[i]);
            }
        }
        return false;
    }
    
}