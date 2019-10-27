package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] matrixOne = new char[rows][cols];
        char[][] matrixTwo = new char[rows][cols];

        for (int row = 0; row < rows * 2; row++) {
            String[] line = reader.readLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                if (row < rows) {
                    matrixOne[row][col] = line[col].charAt(0);
                }else {
                    matrixTwo[row - rows][col] = line[col].charAt(0);
                }
            }
        }
       char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrixOne.length; row++) {
            for (int col = 0; col < matrixOne[row].length; col++) {
                if (matrixOne[row][col] != matrixTwo[row][col]){
                    matrix[row][col] = '*';
                }else {
                    matrix[row][col] = matrixOne[row][col];
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
