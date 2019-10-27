package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicateMap = new HashMap<>();
        String line;
        while (!"Print".equals(line = reader.readLine())) {
            String[] tokens = line.split(";");

            String command = tokens[0];
            String type = tokens[1];
            String argument = tokens[2];
            String name = type + argument;


            if (command.contains("Add")) {
                Predicate<String> predicate = null;
                switch (type) {
                    case "Starts with":
                        predicate = text ->  text.startsWith(argument);
                        break;
                    case "Ends with":
                        predicate = text -> text.endsWith(argument);
                        break;
                    case "Length":
                        predicate = text -> text.length() == Integer.parseInt(argument);
                        break;
                    case "Contains":
                        predicate = text -> text.contains(argument);
                        break;
                }
                predicateMap.putIfAbsent(name,predicate);
            } else {
                predicateMap.remove(name);
            }
        }
        for (String name : names) {
            boolean isValid = true;
            for (String predicateName : predicateMap.keySet()) {
                if (predicateMap.get(predicateName).test(name)){
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                System.out.print(name + " ");
            }
        }
        
    }

//    private static Predicate<String> criteria(String type, String argument) {
//        switch (type) {
//            case "Starts with":
//                return text -> text.startsWith(argument);
//            case "Ends with":
//                return text -> text.endsWith(argument);
//            case "Length":
//                return text -> text.length() == Integer.parseInt(argument);
//            case "Contains":
//                return text -> text.contains(argument);
//            default:
//                return text -> false;
//        }
//    }
}
