package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[]rowCol = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(rowCol[0]);
        int cols = Integer.parseInt(rowCol[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
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
