package task4;

import java.io.*;

class CopyFilesDirectlyTask extends AbstractCopyFilesTask {

    CopyFilesDirectlyTask(File aSourceFile, File aDestFile) {
        super (aSourceFile, aDestFile);
    }

    @Override
    protected void copyFiles(File source, File dest) throws IOException {
        try (InputStream sourceStream = new FileInputStream(source);
             OutputStream destStream = new FileOutputStream(dest)) {

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
}
