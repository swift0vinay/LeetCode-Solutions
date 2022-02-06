class Bitset {
    HashSet<Integer> hs;
    int n;
    boolean flipped;
    public Bitset(int size) {
        n=size;
        hs=new HashSet<Integer>();
        flipped=false;
    }
    
    public void fix(int idx) {
        if(!flipped)
            hs.add(idx);
        else
            hs.remove(idx);
    }
    
    public void unfix(int idx) {
        if(!flipped)
            hs.remove(idx);
        else
            hs.add(idx);
    }
    
    public void flip() {
        flipped=!flipped;
    }
    
    public boolean all() {
        return count()==n;
    }
    
    public boolean one() {
        return count()>=1;
    }
    
    public int count() {
        return flipped?(n-hs.size()):hs.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(flipped == hs.contains(i) ? '0' : '1');
		}
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */