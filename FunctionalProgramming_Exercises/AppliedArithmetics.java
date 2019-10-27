package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<int[],int[]> add = arr -> Arrays.stream(arr).map(e -> e + 1).toArray();
        Function<int[],int[]> subtract = arr -> Arrays.stream(arr).map(e -> e - 1).toArray();
        Function<int[],int[]> multiply = arr -> Arrays.stream(arr).map(e -> e * 2).toArray() ;
        Consumer<int []> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        int [] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command;
        while (!"end".equals(command = reader.readLine())){
            if (command.equals("add")){
                input = add.apply(input);
            }else if (command.equals("subtract")){
               input = subtract.apply(input);
            }else if (command.equals("multiply")){
                input = multiply.apply(input);
            }else if (command.equals("print")){
                print.accept(input);
                System.out.println();
            }
        }
    }
}
