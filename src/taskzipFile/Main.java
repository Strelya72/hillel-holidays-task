package taskzipFile;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Wrong number of arguments");
            System.out.println("Usage: app.jar.file dest.file");

            return;
        }

        // validate source file
        final File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.err.println("Source does not exist: " + args[0]);
            return;
        }


        // validate dest file
        final File destFile = new File(args[1]);
        if (destFile.exists() && !destFile.isFile()) {
            System.err.println("Destination is not file: " + args[1]);
            return;
        }
        destFile.getParentFile().mkdirs();

        try {
            addFileToZip("", sourceFile, new ZipOutputStream(new FileOutputStream(destFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void closeZipWriter(ZipOutputStream zos) throws IOException {
        zos.flush();
        zos.close();
    }

    public static void addFileToZip(String path, File source, ZipOutputStream zos) throws IOException {
        InputStream sourceStream = new FileInputStream(source);

        byte[] buffer = new byte[4096];

        zos.putNextEntry(new ZipEntry(path + source.getName()));

        while (sourceStream.available() > 0) {
            int readCount = sourceStream.read(buffer);
            zos.write(buffer, 0, readCount);
        }
        closeZipWriter(zos);
    }
}
