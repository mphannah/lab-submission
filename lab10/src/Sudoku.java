import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

class Sudoku {
    private static final int EMPTY = -1;

    private final int dim;
    private final int sdim;
    private final int[][] cells;
    private int backtracking;

    public Sudoku (int[][] cells) {
        this.dim = cells.length;
        this.sdim = (int)Math.sqrt(dim);
        this.cells = cells;
        this.backtracking = 0;
    }

    // TODO: Check if a certain cell in table is empty or not. If the value can be placed, then return true.
    public boolean isBlank (int row, int col) {
        if (cells[row][col] == -1) {
            return true;
        }
        return false;
    }

    // TODO: Check if the row/column/block has that value. If the value can be placed, then return true.
    public boolean isValid (int val, int row, int col) {
        return isBlank(row, col) &&
                checkRow(val, row) &&
                checkCol(val, col) &&
                checkBlock(val, row, col);
    }

    // TODO: Check if the value is in the row. If the value can be placed, then return true.
    private boolean checkRow (int val, int row) {
        for (int i = 0; i < 9; i++) {
            if (cells[row][i] == val) {
                return false;
            }
        }
        return true;
    }

    // TODO: Check if the value is in the column. If the value can be placed, then return true.
    private boolean checkCol (int val, int col) {
        for (int i = 0; i < 9; i++) {
            if (cells[i][col] == val) {
                return false;
            }
        }
        return true;
    }

    // TODO: Check if the value is in the block. If the value can be placed, then return true.
    private boolean checkBlock (int val, int row, int col) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i <= startRow+2; i ++) {
            for (int x = startCol; x <= startCol+2; x++) {
                if (cells[i][x] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString () {
        StringBuilder res = new StringBuilder();
        for (int j=0; j<dim; j++) {
            if (j % sdim == 0) res.append("――――――――――――――――――――――\n");
            for (int i=0; i<dim; i++) {
                if (i % sdim == 0) res.append("│");
                int c = cells[i][j];
                res.append(c == EMPTY ? "." : c);
                res.append(" ");
            }
            res.append("│\n");
        }
        res.append("――――――――――――――――――――――\n");
        return res.toString();
    }

    //------------------------------------------------------------

    public static Sudoku read (Scanner s) {
        int dim = s.nextInt();
        int[][] cells = new int[dim][dim];
        for (int j = 0; j < dim; j++)
            for (int i = 0; i < dim; i++) {
                String c = s.next();
                cells[i][j] = c.equals(".") ? EMPTY : Integer.parseInt(c);
            }
        return new Sudoku(cells);
    }
}