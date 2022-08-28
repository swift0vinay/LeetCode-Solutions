class Solution {
    public String removeStars(String s) {
        ArrayDeque<Character> dq=new ArrayDeque<>();
        for(char x : s.toCharArray()) {
            if(x=='*') {
                dq.pollLast();
            }else{
                dq.add(x);
            }
        }
        StringBuilder ss = new StringBuilder();
        for(char x : dq) ss.append(x);
        return ss.toString();
    }
}