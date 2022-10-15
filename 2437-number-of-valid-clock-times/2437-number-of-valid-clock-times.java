class Solution {
    public int countTime(String time) {
      int ans=0;
      HashSet<String> set=new HashSet<String>();
      char ar[]=time.toCharArray();
      for(int i=0;i<3;i++){
          int a=0;
          if(ar[0]=='?'){
              a=i;
          }else{
              a=ar[0]-'0';
          }
          for(int j=0;j<10;j++){
              int b=0;
              if(ar[1]=='?'){
                  b+=j;
              }else{
                  b+=ar[1]-'0';
              }
              for(int k=0;k<6;k++){
                  int c=0;
                  if(ar[3]=='?'){
                      c=k;
                  }else{
                      c=ar[3]-'0';
                  }
                  for(int l=0;l<10;l++){
                      int d=0;
                      if(ar[4]=='?'){
                          d+=l;
                      }else{
                          d+=ar[4]-'0';
                      }
                      if((a*10+b)<=23 && (c*10+d)<=59){
                          if(!set.contains((a*10+b)+":"+(c*10+d))){
                              set.add((a*10+b)+":"+(c*10+d));
                              ++ans;
                          }
                      }
                  }
              }
          }
      }
      return ans;
    }
}