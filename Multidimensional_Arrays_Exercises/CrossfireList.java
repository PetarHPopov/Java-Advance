package Multidimensional_Arrays_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrossfireList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> matrix = getMatrix(rows, cols);

        String line = reader.readLine();
        while (!"Nuke it from orbit".equals(line)) {
            String[] tokens = line.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int column = Integer.parseInt(tokens[1]);
            int destroy = Integer.parseInt(tokens[2]);

            for (int r = row - destroy; r <= row + destroy; r++) {
                if (isRange(matrix, r, column)) {
                    matrix.get(r).set(column, 0);
                }
            }
            for (int c = column - destroy; c <= column + destroy; c++) {
                if (isRange(matrix,row,c)){
                    matrix.get(row).set(c,0);
                }
            }

            for (int r = 0; r < matrix.size(); r++) {
                matrix.set(r,matrix.get(r).stream().filter(e -> e != 0)
                        .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(r).size() == 0){
                    matrix.remove(r);
                    r--;
                }
            }


            line = reader.readLine();
        }

        printMatrix(matrix);
    }

    private static boolean isRange(ArrayList<ArrayList<Integer>> matrix, int row, int cols) {
        return row >= 0 && row < matrix.size() && cols >= 0 && cols < matrix.get(row).size();
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> getMatrix(int rows, int cols) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int value = 1;
        for (int r = 0; r < rows; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                row.add(value);
                value++;
            }
            matrix.add(row);
        }

        return matrix;
    }
}
