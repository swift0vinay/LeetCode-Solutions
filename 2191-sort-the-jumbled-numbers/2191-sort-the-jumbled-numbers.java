class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int x:nums){
            hm.put(x,getVal(x,mapping));
            al.add(x);
        }
        Collections.sort(al,(a,b)->hm.get(a)-hm.get(b));
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