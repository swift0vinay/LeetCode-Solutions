class Solution {
    public int countDistinct(int[] ar, int k, int p) {
        int ans=0;
        int need=k+1,curr=0;
        int start=0,end=0;
        ArrayList<int[]> al=new ArrayList<>();
        while(end<ar.length){
            if(ar[end]%p==0){
                ++curr;
            }
            if(curr>=need){
                al.add(new int[]{start,end-1});
                while(start<end && curr>=need){
                    if(ar[start]%p==0){
                        --curr;
                    }
                    ++start;
                }
            }
            ++end;
        }
        al.add(new int[]{start,end-1});
        HashSet<String> set=new HashSet<>();
        for(int[] x:al){
            int a=x[0],b=x[1];
            for(int i=a;i<=b;i++){
                StringBuilder ss=new StringBuilder();
                for(int j=i;j<=b;j++){
                    ss.append(ar[j]+"-");
                    set.add(ss.toString());
                }
            }
        }
        return set.size();
    }
}