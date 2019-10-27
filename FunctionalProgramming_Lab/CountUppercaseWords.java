package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> upperCase = word -> Character.isUpperCase(word.charAt(0)) ;

        Consumer<String> wordUpper = System.out::println;

        String[] text = reader.readLine().split(" ");

        System.out.println(Arrays.stream(text).filter(upperCase).count());

        for (String word : text) {
            boolean upper = upperCase.test(word);
            if (upper) {
                System.out.println(word);
            }
        }
       // Arrays.stream(text).filter(upperCase).forEach(wordUpper);
    }
}
