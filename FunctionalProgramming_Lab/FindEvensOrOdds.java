package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<Integer> odd = element -> element % 2 != 0;
        Predicate<Integer> even = element -> element % 2 == 0;

        String[] input = reader.readLine().split("\\s+");

        int begin = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        String criteria = reader.readLine();

        Predicate<Integer> byType = even;

        if (criteria.equals("odd")){
            byType = odd;
        }

        IntStream.rangeClosed(begin,end).boxed().filter(byType).forEach(e -> System.out.print(e + " "));
    }
}
