class Solution {
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length<2) return 0;

        int prev2=cost[0];
        int prev1=cost[1];

        for(int i=2;i<cost.length;i++){
            int current=cost[i]+Math.min(prev2,prev1);
            prev2=prev1;
            prev1=current;
        }
        return Math.min(prev1,prev2);
        
    }
}