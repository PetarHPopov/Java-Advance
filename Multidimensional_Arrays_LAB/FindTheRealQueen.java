package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTheRealQueen {
    private static int SIZE = 8;
    private static char Queen = 'q';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] chessTable = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            String[] line = reader.readLine().split(" ");
            for (int col = 0; col < SIZE; col++) {
                chessTable[row][col] = line[col].charAt(0);
            }
        }
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (chessTable[row][col] == Queen) {
                    if (isValidQueen(chessTable, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isValidQueen(char[][] chessTable, int row, int col) {
        return isValidRow(chessTable, row) &&
                isValidCol(chessTable, col) &&
                isValidFirst(chessTable, row, col) &&
                isValidSecond(chessTable, row, col);
    }

    private static boolean isValidSecond(char[][] chessTable, int row, int col) {
        int countQueen = 0;

        for (int i = 1; row - i >= 0 && col + i < SIZE; i++) {
            if (chessTable[row - i][col + i] == Queen) {
                countQueen++;
            }
        }
        for (int i = 1; row + i < SIZE && col - i >= 0; i++) {
            if (chessTable[row + i][col - i] == Queen) {
                countQueen++;
            }
        }

        return countQueen == 0;
    }

    private static boolean isValidFirst(char[][] chessTable, int row, int col) {
        int countQueen = 0;

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (chessTable[row - i][col - i] == Queen) {
                countQueen++;
            }
        }
        for (int i = 1; row + i < SIZE && col + i < SIZE; i++) {
            if (chessTable[row + i][col + i] == Queen) {
                countQueen++;
            }
        }
        return countQueen == 0; // защото пропускаме позицията на кралицата
    }

    private static boolean isValidRow(char[][] chessTable, int row) {
        int countQueen = 0;

        for (int i = 0; i < SIZE; i++) {
            if (chessTable[row][i] == Queen) {
                countQueen++;
            }
            if (countQueen > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCol(char[][] chessTable, int col) {
        int countQueen = 0;

        for (int i = 0; i < SIZE; i++) {
            if (chessTable[i][col] == Queen) {
                countQueen++;
            }

            if (countQueen > 1) {
                return false;
            }
        }
        return true;
    }
}
