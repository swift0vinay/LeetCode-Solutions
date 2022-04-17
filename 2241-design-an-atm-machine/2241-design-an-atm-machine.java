class ATM {
    long A[],B[];
    public ATM() {
        A = new long[5];
        B = new long[]{20,50,100,200,500};
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++){
            A[i]+=banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        long AA[]=Arrays.copyOf(A,5);
        for(int i=4;i>=0;i--){
            long reqd = (long)amount/B[i];
            long have = AA[i];
            long can = Long.min(reqd,have);
            AA[i] -= can;
            amount -= (int)(can * B[i]);
            if(amount == 0){
                int diff[]=new int[5];
                for(int j=0;j<5;j++){
                    diff[j]=(int)(A[j]-AA[j]);
                    A[j]=AA[j];
                }
                return diff;
            }
        }
        return new int[]{-1};
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */