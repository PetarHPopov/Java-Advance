package Stacks_And_Queues_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class BrowserHistory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            if (!"back".equals(input)) {
                stack.push(input);
                System.out.println(input);
            } else {
                if (stack.size() > 1){
                    stack.pop();
                    System.out.println(stack.peek());
                }else {
                    System.out.println("no previous URLs");
                }
            }
            input = reader.readLine();
        }
    }
}
