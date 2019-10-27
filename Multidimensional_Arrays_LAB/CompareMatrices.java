package Multidimensional_Arrays_LAB;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] rowCol = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowCol[0]);
        int cols = Integer.parseInt(rowCol[1]);

        int[][] firstMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        rowCol = scanner.nextLine().split("\\s+");

        int rows1 = Integer.parseInt(rowCol[0]);
        int cols1 = Integer.parseInt(rowCol[1]);

        int[][] secondMatrix = new int[rows1][cols1];

        for (int row = 0; row < rows1; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols1; col++) {
                secondMatrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        if ((firstMatrix[0].length != secondMatrix[0].length) || (firstMatrix.length != secondMatrix.length)) {
            System.out.println("not equal");
            return;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
