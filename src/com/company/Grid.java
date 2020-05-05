package com.company;

public class Grid {
    private int[][] grid;
    private final int SIZE = 9, EMPTY_CELL = 0;

    public Grid(int g[][]) {
        this.grid = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.grid[i][j]= g[i][j];
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getCell(int x, int y) {
        return grid[x][y];
    }


    private boolean isInRow(int i, int n) {
        for (int j = 0; j < SIZE; j++) {
            if (grid[i][j]== n) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int i, int n) {
        for (int j = 0; j < SIZE; j++) {
            if (grid[j][i] == n) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (grid[i][j] == number)
                    return true;

        return false;
    }

    public boolean isLeagal(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }

    public boolean solveGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // we search an empty cell
                if (grid[row][col] == EMPTY_CELL) {
                    // we try possible numbers
                    for (int number = 1; number <= SIZE; number++) {
                        if (isLeagal(row, col, number)) {
                            // number ok. it respects sudoku constraints
                            grid[row][col] = number;

                            if (solveGrid()) { // we start backtracking recursively
                                return true;
                            } else { // if not a solution, we empty the cell and we continue
                                grid[row][col] = EMPTY_CELL;
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }

        return true; // sudoku solved
    }
    public void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println("");

        }
        System.out.println("\n");
    }
}
