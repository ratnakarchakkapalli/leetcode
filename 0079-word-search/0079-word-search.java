class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(backtrack(board, i, j, word, 0, m, n)) return true;

            }
        }return false;
        
    }

    boolean backtrack(char[][] board, int i, int j, String word, int index, int m, int n){

        if(index==word.length()) return true;

        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(index)) return false;

        char temp=board[i][j];
        board[i][j]='#';

        boolean found = backtrack(board, i+1, j, word, index+1, m, n) ||
        backtrack(board, i-1, j, word, index+1, m, n) ||
        backtrack(board, i, j+1, word, index+1, m, n) ||
        backtrack(board, i, j-1, word, index+1, m, n);

        board[i][j]=temp;

        return found;

       



    }
}