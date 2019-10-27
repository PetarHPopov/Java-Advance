package Multidimensional_Arrays_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifferenceWhitWhileLoops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int row = 0;
        int col = 0;
        int primarySize = 0;

        while (row < size && col < size) {
            primarySize += matrix[row][col];
            row++;
            col++;
        }
        row = size -1 ;
        col = 0;
        int secondarySum = 0;

        while (row >= 0 && col < size) {
            secondarySum += matrix[row][col];
            row--;
            col++;
        }
        System.out.println(Math.abs(primarySize - secondarySum));
    }
}
