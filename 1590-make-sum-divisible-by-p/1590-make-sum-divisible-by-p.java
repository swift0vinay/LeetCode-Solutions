class Solution {
    public int minSubarray(int[] ar, int p) {
        for(int i=0;i<ar.length;i++) ar[i]%=p;
        int ans=ar.length;
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
        // left
            int ls=0;
            for(int i=0;i<ar.length;i++){
                ls+=ar[i];
                ls%=p;
                if(hm.get(ls)==null){
                   hm.put(ls,new ArrayList<>());
                }
                hm.get(ls).add(i);
                if(ls==0){
                    ans=Integer.min(ans,ar.length-(i+1));
                }
            }
        // right
            int rs=0;
            for(int i=ar.length-1;i>=0;i--){
                rs+=ar[i];
                rs%=p;
                if(rs==0){
                    ans=Integer.min(ans,i);
                }
                int reqd=p-rs;
                // System.out.println("------"+ans);
                if(hm.get(reqd)!=null){
                    ArrayList<Integer> al=hm.get(reqd);
                    // System.out.println(al+" "+reqd);
                    int index=Collections.binarySearch(al,i-1);
                    if(index<0){
                        index=~index-1;
                    }
                    // System.out.println("reqd index "+index);
                    if(index>=0 && index<al.size() && al.get(index)<i){
                        ans=Integer.min(ans,(i-1)-(al.get(index)+1)+1);
                    }
                }
                // System.out.println(ans);
            }
        return ans==ar.length?-1:ans;
    }
}