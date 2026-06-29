class Solution {
    public boolean isValidSudoku(char[][] board) {

        int nr = board.length;
        int nc = board[0].length;

        HashSet<Character>[] rowSeen = new HashSet[nr];
        HashSet<Character>[] colSeen = new HashSet[nc];
        HashSet<Character>[] boxSeen = new HashSet[9];

        for (int r = 0; r < 9; r++) {
            rowSeen[r] = new HashSet<Character>();
            colSeen[r] = new HashSet<Character>();
            boxSeen[r] = new HashSet<Character>();
        }

        for(int i = 0 ; i < nr ; i++)
        {
            for(int j = 0 ; j < nc ; j++)
            {
                if(board[i][j] == '.')
                    continue;
                
                if(rowSeen[i].contains(board[i][j]))
                    return false;
                
                if(colSeen[j].contains(board[i][j]))
                    return false;
                
                int boxNum = ((int)(i/3)*3  + (int)j/3);

                if(boxSeen[boxNum].contains(board[i][j]))
                    return false;

                rowSeen[i].add(board[i][j]);
                colSeen[j].add(board[i][j]);
                boxSeen[boxNum].add(board[i][j]);
                

                
            }
        }

        return true;
        
    }
}
