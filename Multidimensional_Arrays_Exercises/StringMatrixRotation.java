package Multidimensional_Arrays_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("[()]+");

        int rotation = Integer.parseInt(input[1]) % 360;

        List<String> inputStrings = new ArrayList<>();

        String line = reader.readLine();

        int maxLength = line.length();

        while (!"END".equals(line)) {
            inputStrings.add(line);
            line = reader.readLine();
            if (maxLength < line.length()) {
                maxLength = line.length();
            }
        }

        char[][] matrix = new char[inputStrings.size()][maxLength];

        for (int row = 0; row < inputStrings.size(); row++) {
            for (int col = 0; col < maxLength; col++) {
                int currentLength = inputStrings.get(row).length() - 1;
                if (col > currentLength) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputStrings.get(row).charAt(col);
                }
            }
        }
        if (rotation == 90) {
            for (int col = 0; col < maxLength; col++) {
                for (int row = inputStrings.size() - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (rotation == 180) {
            for (int row = inputStrings.size() - 1; row >= 0; row--) {
                for (int col = maxLength - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (rotation == 270) {
            for (int col = maxLength - 1; col >=0; col--) {
                for (int row = 0; row < matrix.length; row ++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < inputStrings.size(); row++) {
                for (int col = 0; col < maxLength; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
