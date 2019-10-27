package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> number = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt).filter(e -> e % 2 == 0).collect(Collectors.toList());

//        printList(number);
//        System.out.println();
//        Collections.sort(number);
//        printList(number);
        List<String> numStr = number.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.print(String.join(", ",numStr));
        Collections.sort(number);
        number.stream().map(String::valueOf).forEach(e -> System.out.print(String.join(", ", e)));
        System.out.println();

    }

    private static void printList(List<Integer> number) {
        for (int i = 0; i < number.size(); i++) {
            if (i != number.size() - 1) {
                System.out.print(number.get(i) + ", ");
            } else {
                System.out.print(number.get(i));
            }
        }
    }
}
