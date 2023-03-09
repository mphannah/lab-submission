import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuTest {
    // aim for 100% code coverage with the methods you write in lab

    int[][] cells = {{8, -1, 5, -1, -1, -1, 6, -1, 3},
                    {-1, -1, -1, 7, -1, 3, -1, -1, -1},
                    {-1, -1, -1, 5, 1, 8, -1, -1, -1},
                    {3, -1, 6, 9, -1, 7, 4, -1, 5},
                    {-1, 2, -1, -1, -1, -1, -1, 9, -1},
                    {9, -1, 8, 3, -1, 4, 1, -1, 7},
                    {-1, -1, -1, 4, 7, 2, -1, -1, -1},
                    {-1, -1, -1, 6, -1, 5, -1, -1, -1},
                    {5, -1, 3, -1, -1, -1, 2, -1, 4}};

    Sudoku sudoku = new Sudoku(cells);

    @Test
    void isBlank(){
        System.out.println(sudoku.toString());
        assertTrue(sudoku.isBlank(1, 1));
        assertTrue(sudoku.isBlank(4,5));
        assertFalse(sudoku.isBlank(5,3));
        assertFalse(sudoku.isBlank(8,8));
        // TODO
    }

    @Test
    void isValid(){
        System.out.println(sudoku.toString());
        assertTrue(sudoku.isValid(4, 1, 1));
        assertTrue(sudoku.isValid(6,6,0));
        assertTrue(sudoku.isValid(1, 8, 7));
        assertFalse(sudoku.isValid(5, 8, 7));
        // TODO
    }
}
