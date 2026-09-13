class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b)->a[1]-b[1]);

        int count=0;

        int end=Integer.MIN_VALUE;

        for(int[] entry: intervals){
            if(entry[0]>=end){
                end=entry[1];
            }else{
                count++;
            }
        }return count;

        
    }
}