class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s=new StringBuilder();

        int m=word1.length();
        int n=word2.length();

        int i=0;
        int j=0;

        while(i<m || j<n){
            if(i<m){
                s.append(word1.charAt(i)); 
                i++;
            } 

            if(j<n){
                s.append(word2.charAt(j)); 
                j++;
            }
        }return s.toString();
        
    }
}