class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
        
    }

    void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result){

        result.add(new ArrayList<>(current));

        for(int i=index;i<nums.length;i++){

            if(i>index && nums[i-1]==nums[i] ) continue;
            current.add(nums[i]);

            backtrack(nums, i+1, current, result);

            current.remove(current.size()-1);
        }
    }
}