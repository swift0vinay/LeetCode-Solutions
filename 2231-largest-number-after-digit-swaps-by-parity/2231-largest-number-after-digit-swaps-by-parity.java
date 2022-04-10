class Solution {
    public int largestInteger(int num) {
        char ar[]=(num+"").toCharArray();
        ArrayList<Integer> a=new ArrayList<Integer>(),b=new ArrayList<>(),c=new ArrayList<>(),d=new ArrayList<>();
        for(int i=0;i<ar.length;i++){
            if((ar[i]-'0')%2==0){
                a.add(ar[i]-'0');
                b.add(i);
            }else{
                c.add(ar[i]-'0');
                d.add(i);
            }
        }
        Collections.sort(a,Collections.reverseOrder());
        Collections.sort(c,Collections.reverseOrder());
        for(int i=0;i<b.size();i++){
            ar[b.get(i)]=(char)(a.get(i)+'0');
        }
        for(int i=0;i<d.size();i++){
            ar[d.get(i)]=(char)(c.get(i)+'0');
        }
        num=0;
        for(char x:ar){
            num*=10;
            num+=(x-'0');
        }
        return num;
    }
}