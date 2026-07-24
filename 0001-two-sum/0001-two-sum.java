class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int result=target-nums[i];

            if(map.containsKey(result)){
                int arr[]={map.get(result), i};
                return arr;
            }else{
                map.put(nums[i],i);
            }
        }return new int[0];
  
    }
}