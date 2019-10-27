package Exercises_Streams_Files_and_Directories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt";

        BufferedReader reader = null;
        PrintWriter printWriter = null;

        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            printWriter = new PrintWriter(outPath);

            String line = reader.readLine();
            while (line != null) {
                line = line.toUpperCase();
                printWriter.println(line);
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }
}
