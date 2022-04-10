class Solution {
    public int largestInteger(int num) {
        char ar[]=(num+"").toCharArray();
        ArrayList<Integer> a=new ArrayList<Integer>(),c=new ArrayList<>();
        for(int i=0;i<ar.length;i++){
            if((ar[i]-'0')%2==0){
                a.add(ar[i]-'0');
            }else{
                c.add(ar[i]-'0');
            }
        }
        Collections.sort(a,Collections.reverseOrder());
        Collections.sort(c,Collections.reverseOrder());
        int i1=0,i2=0;
        for(int i=0;i<ar.length;i++){
            if((ar[i]-'0')%2==0){
                ar[i]=(char)(a.get(i1++)+'0');
            }else{
                ar[i]=(char)(c.get(i2++)+'0');
            }
        }
        num=0;
        for(char x:ar){
            num*=10;
            num+=(x-'0');
        }
        return num;
    }
}