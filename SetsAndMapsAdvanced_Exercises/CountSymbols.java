package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Map<Character,Integer> elements = new TreeMap<>();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (!elements.containsKey(symbol)){
                elements.put(symbol,1);
            }else {
                elements.put(symbol,elements.get(symbol) + 1);
            }
        }

        elements.forEach((k,v)-> {
            System.out.println(String.format("%c: %d time/s",k,v));
        });
    }
}
