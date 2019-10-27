package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Map<String, String> phoneBook = new HashMap<>();

        while (!"search".equals(input)) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, number);
            } else {
                phoneBook.put(name, number);
            }
            input = reader.readLine();
        }
        input = reader.readLine();

        while (!"stop".equals(input)) {
            String criteria = input;

            if (phoneBook.containsKey(criteria)){
                System.out.println(String.format("%s -> %s",criteria,phoneBook.get(criteria)));
            }else {
                System.out.println(String.format("Contact %s does not exist.",criteria));
            }
            input = reader.readLine();
        }
    }
}
