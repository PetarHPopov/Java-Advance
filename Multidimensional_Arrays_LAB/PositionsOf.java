package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PositionsOf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rowCol = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(rowCol[0]);
        int cols = Integer.parseInt(rowCol[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int number = Integer.parseInt(reader.readLine());
        boolean notFound = true;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == number) {
                    System.out.println(row + " " + col);
                    notFound = false;
                }
            }
        }
        if (notFound) {
            System.out.println("not found");
        }
    }
}
