package task4;

import java.io.*;

public class CopyFilesCustomBufferTask extends AbstractCopyFilesTask {

    protected CopyFilesCustomBufferTask(File aSource, File aDest) {
        super(aSource, aDest);
    }

    @Override
    protected void copyFiles(File source, File dest) throws IOException {

        final InputStream sourceStream = new FileInputStream(source);
        final OutputStream destStream = new FileOutputStream(dest);

        final long totalSize = source.length();
        long totalReadCount = 0;

        byte[] buffer = new byte[16384];

        while (sourceStream.available() > 0) {
            int readCount = sourceStream.read(buffer);
            destStream.write(buffer, 0, readCount);
            totalReadCount += readCount;

            System.out.println(String.format("Progress: %d/%d", totalReadCount, totalSize));
        }

    }
}
