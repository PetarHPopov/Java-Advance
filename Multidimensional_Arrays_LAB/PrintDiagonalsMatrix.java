package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintDiagonalsMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = reader.readLine().split(" ");
            matrix[row] = line;
        }
        for (int i = 0; i < size ; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[size -1 -i][i] + " ");
        }
        System.out.println();
    }
}
