package javacollectionstreams.iostreams;
import java.io.*;
import java.util.Scanner;

/*
 Program: File Copy using FileInputStream and FileOutputStream
 Description:
 Reads content from a source file and writes it into a destination file.
 If source file does not exist, shows an error message.
*/

public class FileCopyBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for file names
        System.out.print("Enter source file name: ");
        String source = sc.nextLine();

        System.out.print("Enter destination file name: ");
        String dest = sc.nextLine();

        // Using try-with-resources for automatic closing
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int data;
            // Reading byte by byte
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found!");
        } catch (IOException e) {
            System.out.println("Error while copying file.");
        }
    }
}
