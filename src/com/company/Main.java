package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int gridToSolve[][] = {{8, 0, 0, 4, 0, 6, 0, 0, 3},
                {0, 0, 9, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 8, 0, 0, 4, 0, 0},
                {0, 6, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 3, 0, 0, 2, 0, 0, 9},
                {7, 0, 2, 0, 3, 0, 0, 0, 0},
                {0, 4, 0, 0, 0, 0, 5, 0, 0},
                {5, 0, 1, 7, 0, 9, 0, 0, 8}};
        Grid sudoku = new Grid(gridToSolve);
        System.out.println("this is the grid: ");
        sudoku.printGrid();
        if(sudoku.solveGrid()){
            System.out.println("successful solve \nthis is the solved grid:");
            sudoku.printGrid();
        }
        else{
            System.out.println("unsolvable sudoku");
        }
    }
}
