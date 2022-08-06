class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long ans=0;
        long day=1;
        HashMap<Integer,Long> hm = new HashMap<Integer,Long>();
        for(int i=0;i<tasks.length;i++){
            if(hm.get(tasks[i])==null){
                hm.put(tasks[i],day);
                ++day;
                continue;
            }
            long lastDone = hm.get(tasks[i]);
            if(day-lastDone>space) {
                //can Do
                hm.put(tasks[i],day);
                ++day;
            }else{
                //cannot
                long left = day-lastDone;
                long reqd=space-left;
                day += reqd;
                ++day;
                --i;
            }
        }
        return day-1;
    }
}