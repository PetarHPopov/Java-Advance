package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Set<String> chemical = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            List<String> tokens = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
            chemical.addAll(tokens);
        }
        chemical.forEach(e -> System.out.print(e + " "));
    }
}
