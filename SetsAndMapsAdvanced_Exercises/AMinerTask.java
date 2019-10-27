package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line ;

        Map<String,Integer> resourceByQuantity = new LinkedHashMap<>();

        while (!"stop".equals(line = reader.readLine())){
            String resource = line;
            int quantity = Integer.parseInt(reader.readLine());
          resourceByQuantity.putIfAbsent(resource,0);
          resourceByQuantity.put(resource,resourceByQuantity.get(resource) + quantity);
        }
        resourceByQuantity.forEach((k,v)-> {
            System.out.println(String.format("%s -> %d",k,v));
        });
    }
}
