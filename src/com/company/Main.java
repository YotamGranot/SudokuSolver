package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        int gridToSolve[][] = new int[9][9];
        System.out.println("Enter Matrix Data");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gridToSolve[i][j] = in.nextInt();
            }
        }
        Grid sudoku = new Grid(gridToSolve);
        System.out.println("this is the grid: ");
        sudoku.printGrid();
        if (sudoku.solveGrid()) {
            System.out.println("successful solve \nthis is the solved grid:");
            sudoku.printGrid();
        } else {
            System.out.println("unsolvable sudoku");
        }
    }
}