package StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String inPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        List<Character> symbols = Arrays.asList(',','.','!','?');

        try {
            fileInputStream = new FileInputStream(inPath);
            fileOutputStream = new FileOutputStream(outPath);

            int in = fileInputStream.read();

            while (in >=0) {
                if (!symbols.contains((char)in)) {
                    fileOutputStream.write(in);
                }
                in = fileInputStream.read();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
