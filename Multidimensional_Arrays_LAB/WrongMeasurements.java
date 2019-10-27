package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WrongMeasurements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        int[][] inputMatrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inputMatrix[row] = line;
        }
        String[] coordinates = reader.readLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        int wrongValue = inputMatrix[x][y];

        int[][] resultMatrix = new int[size][];

        for (int row = 0; row < size; row++) {
            resultMatrix[row] = new int[inputMatrix[row].length];
            for (int col = 0; col < inputMatrix[row].length; col++) {
                if (inputMatrix[row][col] != wrongValue) {
                    resultMatrix[row][col] = inputMatrix[row][col];
                } else {
                    int sum = 0;
                    if (row - 1 >= 0 && inputMatrix[row - 1][col] != wrongValue) {
                        sum += inputMatrix[row - 1][col];
                    }
                    if (row + 1 < inputMatrix.length && inputMatrix[row + 1][col] != wrongValue) {
                        sum += inputMatrix[row + 1][col];
                    }
                    if (col - 1 >= 0 && inputMatrix[row][col - 1] != wrongValue) {
                        sum += inputMatrix[row][col - 1];
                    }
                    if (col + 1 < inputMatrix[row].length && inputMatrix[row][col + 1] != wrongValue) {
                        sum += inputMatrix[row][col + 1];
                    }
                    resultMatrix[row][col] = sum;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
