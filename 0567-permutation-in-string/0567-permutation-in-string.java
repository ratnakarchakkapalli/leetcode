class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        int count[]=new int[26];
        int window[]=new int[26];

        for(char c: s1.toCharArray()){
            count[c-'a']++;
        }

        for(int i=0;i<s1.length();i++){
            window[s2.charAt(i)-'a']++;
        }

        if(equal(count, window)) return true;

        int left=0;
        int right=s1.length();

        while(right<s2.length()){
            window[s2.charAt(left)-'a']--;

            window[s2.charAt(right)-'a']++;

            if(equal(count, window)) return true;

            left++;
            right++;

        }return false;

        
        
    }


    boolean equal(int arr1[], int arr2[]){
        for(int i=0;i<26;i++){
            if(arr1[i]==arr2[i]) continue;

            return false;

        }return true;
    }
}