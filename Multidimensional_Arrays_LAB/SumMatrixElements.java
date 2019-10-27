package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rowCol = reader.readLine().split(", ");
        int rows = Integer.parseInt(rowCol[0]);
        int cols = Integer.parseInt(rowCol[1]);

        int sum = 0;

        for (int row = 0; row <rows; row++) {
            String[] line = reader.readLine().split(", ");
            for (int col = 0; col < cols; col++) {
                sum += Integer.parseInt(line[col]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
