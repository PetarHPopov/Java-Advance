package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isValid = true;

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol == '(' ||  symbol == '{' || symbol == '[' ){
                stack.push(symbol);
            }else {
                if (stack.isEmpty()){
                    isValid = false;
                    break;
                }

                char currentSymbol = stack.pop();

                if (symbol == ')' && currentSymbol != '('){
                    isValid = false;
                    break;
                }else if (symbol == '}' && currentSymbol != '{'){
                    isValid = false;
                    break;
                }else if (symbol == ']' && currentSymbol != '['){
                    isValid =false;
                    break;
                }
            }
        }
        if (isValid){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
