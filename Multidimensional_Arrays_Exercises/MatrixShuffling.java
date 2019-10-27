package Multidimensional_Arrays_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split("\\s+");
            matrix[row] = line;
        }

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals("swap") && tokens.length == 5) {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if ((row1 >= 0 && row1 < rows) && (row2 >= 0 && row2 < rows) &&
                        (col1 >= 0 && col1 < cols) && (col2 >= 0 && col2 < cols)) {

                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }
            line = reader.readLine();
        }
    }
}
