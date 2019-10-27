package Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String current ="";

        while(!line.equals("Home")) {
            if(line.equals("back")) {
                if(!browser.isEmpty()) {
                    forward.push(current);
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else if (line.equals("forward")) {
                if(!forward.isEmpty()) {
                    browser.push(current);
                    current = forward.pop();
                } else {
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                }
            }else  {
                if(!current.equals("")) {
                    browser.push(current);
                    if (!forward.isEmpty()){
                        forward.clear();
                    }
                }
                current = line; }
            System.out.println(current);
            line = scanner.nextLine(); }
    }
}
