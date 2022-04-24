class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int ar[]:flowers){
            int x=ar[0],y=ar[1]+1;
            hm.put(x,hm.getOrDefault(x,0)+1);
            hm.put(y,hm.getOrDefault(y,0)-1);
        }
        int[] keys=hm.keySet().stream().mapToInt(i->i).toArray();
        Arrays.sort(keys);
        int sum=0;
        ArrayList<int[]> range=new ArrayList<>();
        for(int i=0;i<keys.length-1;i++){
            sum+=hm.get(keys[i]);
            int end=keys[i+1]-1;
            range.add(new int[]{keys[i],end,sum});
        }
        sum+=hm.get(keys[keys.length-1]);
        range.add(new int[]{keys[keys.length-1],Integer.MAX_VALUE,sum});
 int ans[]=new int[persons.length];
        for(int i=0;i<persons.length;i++){
            int x=persons[i];
            int start=0,end=range.size()-1;
            while(start<=end){
                int mid=(start+end)/2;
                int r[] =range.get(mid);
                if(x>=r[0] && x<=r[1]){
                    ans[i]=r[2];
                    break;
                }else if(x<r[0]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}