package jp.dsa.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReplaceInJsonString {

    public static void main(String[] args) {
        String inputFilePath = "/Users/jeevanjyoti/Downloads/input.json";  // Path to the input file
        String outputFilePath = "/Users/jeevanjyoti/Downloads/output.json";  // Path to the output JSON file

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            // Start of JSON array
            writer.write("[\n");
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Remove '{"json":' from the beginning and '}' from the end of each line
                if (line.startsWith("{\"json\":") && line.endsWith("}")) {
                    line = line.substring(8, line.length() - 1).trim();
                }

                // Write the modified line to the output file with a comma at the end
                writer.write(line + ",\n");
            }
            // add the closing bracket
            writer.write("\n]\n");
            System.out.println("Formatting completed successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
