package Exercises_Streams_Files_and_Directories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String inPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            long sum = 0;
           String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                line = reader.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
