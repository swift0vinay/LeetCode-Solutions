class Solution {
     public String largestPalindromic(String num) 
    {
        int n=num.length();
        
        int freq[]=new int[10];
        for(int i=0;i<n;i++)
        freq[num.charAt(i)-'0']+=1;
        
        int a[]=new int[n];
        Arrays.fill(a,10);
        
        int start=0;
        int end=n-1;
        
        for(int i=9;i>=0;i--)
        {
            int count=freq[i];
            
            while(count>1)
            {
                a[start++]=i;
                a[end--]=i;
                count-=2;
            }
            
            freq[i]=count;
        }
        
        for(int i=9;i>=0;i--)
        {
            if(freq[i]==1)
            {
                a[start++]=i;
                break;
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(a[i]!=10)
            sb.append(a[i]);
        }
        
        while(sb.length()>0 && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
            
            if(sb.length()==0)
            break;
            
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(sb.toString().compareTo("")==0)
        sb.append(0);
        
        return sb.toString();
    }
}