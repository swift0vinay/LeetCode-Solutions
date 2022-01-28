class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int max=(int)Math.pow(2,words.length);
        int n=words.length;
        int total=0;
        int letterCount[]=new int[26];
        for(char x:letters){
            letterCount[x-'a']++;
        }
        for(int i=1;i<max;i++){
            int cp[]=Arrays.copyOf(letterCount,letterCount.length);
            char bin[]=Integer.toBinaryString(i).toCharArray();
            int end=n-1,end2=bin.length-1;
            int count=0;
            boolean rs=true;
            while(end2>=0 && end>=0){
                if(bin[end2]=='1'){
                    String word=words[end];
                    for(char xx:word.toCharArray()){
                        int c=xx-'a';
                        if(cp[c]>0){
                            --cp[c];
                            count+=score[c];
                        }else{
                            rs=false;
                            break;
                        }
                    }
                }
                if(!rs){
                    break;
                }
                --end;
                --end2;
            }
            if(!rs){
                continue;
            }
            // System.out.println(String.valueOf(bin)+" "+count);
            total=Integer.max(total,count);
        }
        return total;
    }
}