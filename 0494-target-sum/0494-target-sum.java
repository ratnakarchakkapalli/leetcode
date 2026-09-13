class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ans(nums,0,0,target);
        
    }

    int ans(int[] nums,int i, int sum, int target){


        if(i==nums.length) return sum==target ? 1:0;

        int add=ans(nums,i+1,sum+nums[i],target);
        int subtract=ans(nums,i+1,sum-nums[i],target);

        return add+subtract;
    }
}