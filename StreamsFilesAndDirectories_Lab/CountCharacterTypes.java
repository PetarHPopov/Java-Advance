package StreamsFilesAndDirectories_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(inPath));

           String line = reader.readLine();

            int vowels = 0;
            int consonants = 0;
            int punctuation = 0;

            while (line != null){
                for (char oneByte : line.toCharArray()) {
                    if (oneByte == 'a' || oneByte == 'e' || oneByte == 'i' || oneByte == 'o' || oneByte == 'u') {
                        vowels++;
                    } else if (oneByte == '!' || oneByte == ',' || oneByte == '.' || oneByte == '?') {
                        punctuation++;
                    } else if (oneByte != ' ') {
                        consonants++;
                    }
                }
                line = reader.readLine();
            }
            System.out.println("Vowels: " +vowels);
            System.out.println("Consonants: " +consonants);
            System.out.println("Punctuation: "+punctuation);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

    }
}
