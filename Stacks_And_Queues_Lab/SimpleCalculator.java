package Stacks_And_Queues_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = line.length - 1; i >= 0; i--) {
            stack.push(line[i]);
        }
        while (stack.size() > 1) {

            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operator.equals("+")) {
                stack.push(String.valueOf(firstNum + secondNum));
            } else {
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }
        System.out.println(stack.pop());
    }
}
