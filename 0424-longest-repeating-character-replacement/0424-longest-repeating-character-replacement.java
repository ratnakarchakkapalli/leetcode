class Solution {
    public int characterReplacement(String s, int k) {

        int left=0;
        int maxfrequency=0;
        int maxlength=0;

        int count[]=new int[26];

        for(int right=0;right<s.length();right++){
            int index=s.charAt(right)- 'A';
            count[index]++;

            maxfrequency=Math.max(maxfrequency, count[index]);
            int windowlength=right-left+1;

            if(windowlength-maxfrequency>k){
                count[s.charAt(left)-'A']--;
                left++;
            }

            maxlength=Math.max(maxlength, right-left+1);

        }
        return maxlength;
        
    }
}