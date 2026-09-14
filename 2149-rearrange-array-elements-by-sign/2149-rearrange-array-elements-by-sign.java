class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result=new int[nums.length];
        int pIndex=0;
        int nIndex=1;

        for(int num:nums){
            if(num>0){
                result[pIndex]=num;
                pIndex+=2;
            }else{
                result[nIndex]=num;
                nIndex+=2;
            }
        }return result;
        
    }
}