class FreqStack {
    
    HashMap<Integer,Integer> hm;
    PriorityQueue<Pair> pq;
    int counter=0;
    public FreqStack() {
        hm=new HashMap<>();
        pq=new PriorityQueue<Pair>((a,b)->b.second!=a.second?b.second-a.second:b.index-a.index);
    }
    
    public void push(int val) {
        hm.put(val,hm.getOrDefault(val,0)+1);
        pq.add(new Pair(val,hm.get(val),counter));
        ++counter;
    }
    
    public int pop() {
        Pair p=pq.poll();
        if(hm.get(p.first)==1){
            hm.remove(p.first);
        }else{
            hm.put(p.first,hm.getOrDefault(p.first,0)-1);
        }
        return p.first;
    }
    
    class Pair{
        int first,second,index;
        Pair(int first,int second,int index){
            this.first=first;
            this.second=second;
            this.index=index;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */