package task4;

import java.io.*;

public class CopyFilesBuiltInBufferedTask extends AbstractCopyFilesTask {
    public CopyFilesBuiltInBufferedTask(File aSource, File aDest) {
        super(aSource, aDest);
    }

    @Override
    protected void copyFiles(File source, File dest) throws IOException {
        final InputStream sourceStream = new BufferedInputStream(new FileInputStream(source));
        final OutputStream destStream = new BufferedOutputStream(new FileOutputStream(dest));

        final long totalSize = source.length();
        long readCount = 0;

        while (sourceStream.available() > 0) {
            int readByte = sourceStream.read();
            destStream.write(readByte);
            readCount++;

            System.out.println(String.format("Progress: %d/%d", readCount, totalSize));
        }
    }

}
