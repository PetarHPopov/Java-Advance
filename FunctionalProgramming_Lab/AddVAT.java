package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        UnaryOperator<Double> vat = v -> v * 1.2;

        System.out.println("Prices with VAT:");

//        for (String v : input) {
//            System.out.println(String.format("%.2f",vat.apply(Double.parseDouble(v))));
//        }

        Arrays.stream(input).map(Double::parseDouble).map(vat).forEach(e -> System.out.printf("%.2f%n",e));
    }
}
