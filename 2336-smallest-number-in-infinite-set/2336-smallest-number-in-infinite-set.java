class SmallestInfiniteSet {
    TreeSet<Integer> hm;
    public SmallestInfiniteSet() {
        hm = new TreeSet<>();
        for(int i=1;i<=2000;i++)
            hm.add(i);
    }
    
    public int popSmallest() {
        return hm.pollFirst();
    }
    
    public void addBack(int num) {
        hm.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */