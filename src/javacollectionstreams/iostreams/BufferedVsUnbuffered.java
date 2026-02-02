package javacollectionstreams.iostreams;
import java.io.*;
import java.util.Scanner;

/*
 Program: Buffered vs Unbuffered File Copy
 Copies a file using both methods and compares execution time.
*/

public class BufferedVsUnbuffered {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file: ");
        String source = sc.nextLine();

        // Unbuffered
        long start1 = System.nanoTime();
        copyUnbuffered(source, "unbuffered_copy.dat");
        long end1 = System.nanoTime();

        // Buffered
        long start2 = System.nanoTime();
        copyBuffered(source, "buffered_copy.dat");
        long end2 = System.nanoTime();

        System.out.println("Unbuffered Time: " + (end1 - start1) + " ns");
        System.out.println("Buffered Time: " + (end2 - start2) + " ns");
    }

    // Unbuffered copy
    static void copyUnbuffered(String src, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fis.close();
        fos.close();
    }

    // Buffered copy
    static void copyBuffered(String src, String dest) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bis.close();
        bos.close();
    }
}

