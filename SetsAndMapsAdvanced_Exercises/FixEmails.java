package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Map<String,String> users = new LinkedHashMap<>();
//        String regex = "\\.([bg]+)";
//        Pattern pattern = Pattern.compile(regex);

        while (!"stop".equals(input)){
            String name = input;
            String email = reader.readLine();
//            Matcher matcher = pattern.matcher(email);
//            if (matcher.find()){
//                users.putIfAbsent(name,email);
//            }
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")){
                users.putIfAbsent(name,email);
            }
            input = reader.readLine();
        }
        users.forEach((k,v)-> {
            System.out.println(String.format("%s -> %s",k,v));
        });
    }
}
