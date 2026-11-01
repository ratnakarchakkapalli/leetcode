class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result=new ArrayList<>();

        String letters[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        backtrack(digits, 0, new StringBuilder(), letters, result);

        return result;


        
    }

    void backtrack(String digits, int index, StringBuilder current, String letters[], List<String> result){

        if(index==digits.length()){
            result.add(current.toString());
            return;
        }

        int digit=digits.charAt(index) - '0';

        String possibleLetters=letters[digit];

        for(int i=0;i<possibleLetters.length();i++){
            current.append(possibleLetters.charAt(i));

            backtrack(digits,index+1,current, letters, result);

            current.deleteCharAt(current.length()-1);
        }
    }
}