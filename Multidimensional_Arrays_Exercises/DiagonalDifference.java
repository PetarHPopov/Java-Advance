package Multidimensional_Arrays_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = line;
        }
        int sumFirstDiagonal = 0;
        for (int i = 0; i < size; i++) {
            sumFirstDiagonal += matrix[i][i];
        }
        int sumSecondDiagonal = 0;
        for (int i = 0; i < size; i++) {
            sumSecondDiagonal += matrix[i ][matrix.length - 1 - i];
        }
        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }
}
