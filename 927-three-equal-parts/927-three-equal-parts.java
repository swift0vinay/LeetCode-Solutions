class Solution {
    public int[] threeEqualParts(int[] ar) {
        int total_ones=0;
        for(int x:ar) if(x==1) ++total_ones;
        if(total_ones%3!=0)
            return new int[]{-1,-1};
        int reqd=total_ones/3;
        if(reqd==0)
            return new int[]{0,2};
        int n=ar.length;
        int index1=n-1,curr=0;
        StringBuilder first=new StringBuilder(),second=new StringBuilder(),third=new StringBuilder();
        int stop1=-1,stop2=-1;
        int leading=0;boolean found=false;
        while(index1>=0 && curr!=reqd){
            first.append(ar[index1]);
            if(ar[index1]==1)
            {
                ++curr;
                found=true;
            }
            if(!found)
                ++leading;
            --index1;
        }
        stop1=index1+1;
        int temp=leading;
        while(index1>=0 && ar[index1]!=1)
        {
            --temp;
            --index1;
        }   
        if(temp>0)
            return new int[]{-1,-1};
        stop1+=temp;
        curr=0;
        index1=stop1-1;
        while(index1>=0 && curr!=reqd){
            second.append(ar[index1]);
            if(ar[index1]==1)
                ++curr;
            --index1;
        }
        stop2=index1;
        temp=leading;
        while(index1>=0 && ar[index1]!=1)
        {
            --index1;
            --temp;
        }
        if(temp>0)
            return new int[]{-1,-1};
        stop2+=temp;
        index1=stop2;
        curr=0;
        while(index1>=0 && curr!=reqd){
            third.append(ar[index1]);
            if(ar[index1]==1)
                ++curr;
            --index1;
        }
        if(first.toString().equals(second.toString()) && second.toString().equals(third.toString())){
            return new int[]{stop2,stop1};
        }
        return new int[]{-1,-1};
    }
}