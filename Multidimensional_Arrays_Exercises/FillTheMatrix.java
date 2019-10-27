package Multidimensional_Arrays_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        int sizeMatrix = Integer.parseInt(input[0]);
        String typeMatrix = input[1];

        int[][] resultMatrix = new int[sizeMatrix][sizeMatrix];

        if (typeMatrix.equals("A")) {
            fillTheMatrixTypeA(sizeMatrix, resultMatrix);
        } else if (typeMatrix.equals("B")) {
            fillTheMatrixTypeB(sizeMatrix, resultMatrix);
        }
        for (int[] matrix : resultMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrixTypeA(int sizeMatrix, int[][] resultMatrix) {
        int index = 1;
        for (int col = 0; col < sizeMatrix; col++) {
            for (int row = 0; row < sizeMatrix; row++) {
                resultMatrix[row][col] = index++;
            }
        }
    }

    private static void fillTheMatrixTypeB(int sizeMatrix, int[][] resultMatrix) {
        int index = 1;
        for (int col = 0; col < sizeMatrix; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < sizeMatrix; row++) {
                    resultMatrix[row][col] = index++;
                }
            }else {
                for (int row = resultMatrix.length - 1 ; row >= 0; row--) {
                    resultMatrix[row][col] = index++;
                }
            }
        }
    }
}
