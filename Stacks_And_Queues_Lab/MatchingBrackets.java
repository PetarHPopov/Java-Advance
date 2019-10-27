package Stacks_And_Queues_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < line.length() ; index++) {
            char symbol = line.charAt(index);
            if (symbol == '('){
                stack.push(index);
            }else if (symbol == ')'){
                System.out.println(line.substring(stack.pop(), index + 1));
            }
        }
    }
}
