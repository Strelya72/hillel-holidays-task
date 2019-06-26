package task3;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1:");
        System.out.println("Количество файлов: " +
                getCountFiles("E:\\IntelliJ\\StudyHillel\\holidaystask\\test"));

        // Task 2
        System.out.println("Task 2:");
        System.out.println(getTotalFoldeSize("E:\\IntelliJ\\StudyHillel\\holidaystask\\test") + " Bytes");


        // Task 3
        System.out.println("Task 3:");
        showStructure("E:\\IntelliJ\\StudyHillel\\holidaystask\\test");


    }


    /**
     * Displays the structure of the specified folder
     *
     * @param path like 'E:\IntelliJ\StudyHillel\holidaystask\test'
     */
    public static void showStructure(String path) {
        ArrayList<File> listDir = new ArrayList<>();
        listDir.add(new File(path));

        while (!listDir.isEmpty()) {
            File dir = listDir.get(0);
            listDir.remove(0);
            int lastAddIndex = 0;

            String currentPath = dir.getPath().replace(path, "");
            int nestingLevel = currentPath.length() - currentPath.replace(File.separator, "").length();

            System.out.print("|");
            for (int i = 0; i < nestingLevel; i++) {
                System.out.print("\t");
            }
            System.out.println(dir.getName() + " (folder)");

            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    listDir.add(lastAddIndex, item);
                    lastAddIndex++;
                } else {
                    System.out.print("|");
                    for (int i = 0; i <= nestingLevel; i++) {
                        if (i == nestingLevel) {
                            System.out.print("\\____ ");
                        } else {
                            System.out.print("\t");
                        }
                    }
                    System.out.println(item.getName() + " - " + item.length() + "B");
                }
            }
        }
    }

    /**
     * Counts the number of files in a folder and subfolders
     *
     * @param path like 'E:\IntelliJ\StudyHillel\holidaystask\test'
     * @return amount
     */
    private static int getCountFiles(String path) {
        ArrayList<File> listDir = new ArrayList<>();
        listDir.add(new File(path));
        int countFiles = 0;

        while (!listDir.isEmpty()) {
            File dir = listDir.get(0);
            listDir.remove(0);

            for (File item : dir.listFiles()) {
                if (item.isFile()) {
                    countFiles++;
                } else {
                    listDir.add(item);
                }
            }
        }

        return countFiles;
    }

    /**
     * Counts the size of files in a folder and in all subfolders
     * @param path like 'E:\IntelliJ\StudyHillel\holidaystask\test'
     * @return size in bytes
     */
    private static int getTotalFoldeSize(String path) {

        ArrayList<File> listDir = new ArrayList<>();
        listDir.add(new File(path));
        int size = 0;

        while (!listDir.isEmpty()) {
            File dir = listDir.get(0);
            listDir.remove(0);

            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    listDir.add(item);
                    size += getFolderFilesSize(item);
                }
            }
        }

        return size;
    }

    /**
     * Counts the size of all files in a folder.
     * @param dir
     * @return size in bytes
     */
    public static long getFolderFilesSize(File dir) {
        long size = 0;

        if (dir.isFile()) {
            throw new IllegalArgumentException("The argument must be a directory.");
        } else {
            for (File item : dir.listFiles()) {
                if (item.isFile()) {
                    size += item.length();
                }
            }
        }

        return size;
    }
}
