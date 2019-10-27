package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePartyDEMO {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> namesList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String line = reader.readLine();
        while (!"Party!".equals(line)) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];
            String predicateType = tokens[1];
            String predicateArgument = tokens[2];

            if (command.equals("Remove")){
                namesList.removeIf(criteria(predicateType,predicateArgument));
            }else if (command.equals("Double")){
                for (int i = 0; i < namesList.size(); i++) {
                    String guest = namesList.get(i);
                    if (criteria(predicateType,predicateArgument).test(guest)){
                        namesList.add(i++,guest);
                    }
                }
            }
            line = reader.readLine();
        }
        if (namesList.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(namesList);
            System.out.printf("%s are going to the party!",String.join(", ",namesList));
        }

    }

    private static Predicate<String> criteria(String type, String argument) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(argument);
            case "EndsWith":
                return text -> text.endsWith(argument);
            case "Length":
                return text -> text.length() == Integer.parseInt(argument);
            default:
                return text -> false;

        }
    }
}
