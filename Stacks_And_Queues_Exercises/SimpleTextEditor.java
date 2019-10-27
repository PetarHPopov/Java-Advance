package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String text = "";
        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");

            switch (tokens[0]) {
                case "1":
                    history.push(text);
                    text += tokens[1];
                    break;
                case "2":
                    history.push(text);
                    int count = Integer.parseInt(tokens[1]);
                    for (int j = 0; j < count; j++) {

                        text = text.substring(0, text.length() - 1);
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);

                    System.out.println(text.charAt(index - 1));

                    break;
                case "4":
                    text = history.pop();
                    break;
            }
        }
    }
}
