class Solution {
    public int minNumberOfHours(int energy, int experience, int[] e, int[] exp) 
    {
        int n=e.length;
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            if(energy>e[i])
            energy-=e[i];
            
            else
            {
                ans+=e[i]-energy+1;
                energy=1;
            }
            
            if(experience>exp[i])
            experience+=exp[i];
            
            else
            {
                ans+=exp[i]-experience+1;
                experience=exp[i]+1;
                experience+=exp[i];
            }
        }
        
        return ans;
    }

}