package task4;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // check number of args
        if (args.length < 2) {
            System.out.println("Wrong number of arguments");
            System.out.println("Usage: app.jar.file dest.file");

            return;
        }

        // validate source file
        final  String sourceFileName = args[0];
        final File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            System.err.println("Source does not exist: " + sourceFileName);
            return;
        }


        // validate dest file
        final String destFileName = args[1];
        final File destFile = new File(destFileName);
        if (destFile.exists() && !destFile.isFile()) {
            System.err.println("Destination is not file: " + destFileName);
            return;
        }

        destFile.getParentFile().mkdirs();

        // make the copy
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new CopyFilesCustomBufferTask(sourceFile, destFile));
        executor.shutdown();
    }


}
