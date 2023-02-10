package medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        boolean expectedOutput = true;
        char[][] input = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assert expectedOutput == new ValidSudoku().isValidSudoku(input);
        assert expectedOutput == new ValidSudoku().intuitiveBruteForce(input);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!set.add(number + " in row " + i) ||
                            !set.add(number + " in colum " + j) ||
                            !set.add(number + " in block " + (i / 3) + "," + (j / 3)))
                        return false;
                }
            }
        }
        return true;
    }


    public boolean intuitiveBruteForce(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !isValidPlacement(board, board[i][j], i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNumberInRow(char[][] board, char number, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (col != i && board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInCol(char[][] board, char number, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (row != i && board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInBox(char[][] board, char number, int row, int col) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (row != i && col != j && board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPlacement(char[][] board, char number, int row, int col) {
        return !isNumberInBox(board, number, row, col) &&
                !isNumberInCol(board, number, row, col) &&
                !isNumberInRow(board, number, row, col);
    }
}
