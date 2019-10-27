package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SirbiaUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();

        String regex = "(?<singer>[A-Za-z ]+)\\s+@(?<town>[A-Za-z ]+)\\s+(?<ticketsPrice>\\d+)\\s+(?<ticketsCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        String line;
        while (!"End".equals(line = reader.readLine())) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String singer = matcher.group("singer");
                String town = matcher.group("town");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                int sumTicket = ticketsCount * ticketsPrice;
                map.putIfAbsent(town, new LinkedHashMap<>());
                if (!map.get(town).containsKey(singer)){
                    map.get(town).put(singer, 0);
                }

                map.get(town).put(singer, map.get(town).get(singer) + sumTicket);
            }
        }
        map.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("#  %s -> %d", e.getKey(), e.getValue()));
                    });
        });
    }
}
