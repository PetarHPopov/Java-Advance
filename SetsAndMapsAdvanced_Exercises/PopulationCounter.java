package SetsAndMapsAdvanced_Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> map = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = scanner.nextLine())) {

            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            long population = Long.parseLong(tokens[2]);

            map.putIfAbsent(country, new LinkedHashMap<>());
            map.get(country).put(city, 0L);
            map.get(country).put(city, map.get(country).get(city) + population);
        }

       map.entrySet().stream()
               .sorted((a,b)-> {
                   long populationA = a.getValue().values().stream().mapToLong(Long::longValue).sum();
                   long populationB = b.getValue().values().stream().mapToLong(Long::longValue).sum();
                   return Long.compare(populationB,populationA);
               }).forEach(e ->{
                   long population = e.getValue().values().stream().mapToLong(Long::longValue).sum();
           System.out.println(String.format("%s (total population: %d)",e.getKey(),population));
           e.getValue().entrySet().stream().sorted((a,b)-> Long.compare(b.getValue(),a.getValue()))
                   .forEach(entry -> {
                       System.out.println(String.format("=>%s: %d",entry.getKey(),entry.getValue()));
                   });
       });
    }
}
