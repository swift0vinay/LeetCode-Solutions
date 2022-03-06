class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int x:nums) al.add(x);
        Collections.sort(al,(a,b)->getVal(a,mapping)-getVal(b,mapping));
        return al.stream().mapToInt(i->i).toArray();
    }
    int getVal(int x,int[] mapping){
        char ar[]=(x+"").toCharArray();
        int num=0;
        for(char xx:ar){
            int r=(xx-'0');
            num*=10;
            num+=mapping[r];
        }
        return num;
    }
}