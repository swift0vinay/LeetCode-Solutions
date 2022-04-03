class Solution {
    public int convertTime(String current, String correct) {
        int a=get(current),b=get(correct);
        int d=b-a;
        int ar[]={60,15,5,1};
        int ans=0;
        for(int i=0;i<4;i++){
            ans+=d/ar[i];
            d%=ar[i];
        }
        return ans;
    }
    int get(String s){
        return Integer.parseInt(s.substring(0,2))*60+Integer.parseInt(s.substring(3,5));
    }

}