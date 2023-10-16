import java.io.File;
import java.io.IOException;
public class FileOperationsDemo {


        public static void main(String[] args) {
            // Check if a file exists
            String filePath = "sample.txt";
            File file = new File(filePath);
            if (file.exists()) {
                System.out.println(filePath + " exists.");
            } else {
                System.out.println(filePath + " does not exist.");
            }

            // Delete a file and check if it doesn't exist
            if (file.delete()) {
                System.out.println(filePath + " has been deleted.");
            } else {
                System.out.println("Failed to delete " + filePath);
            }

            // Create a directory
            String directoryPath = "my_directory";
            File directory = new File(directoryPath);
            if (directory.mkdir()) {
                System.out.println("Directory " + directoryPath + " created.");
            } else {
                System.out.println("Failed to create " + directoryPath);
            }

            // Create an empty file in the directory
            String newFilePath = directoryPath + File.separator + "new_file.txt";
            File newFile = new File(newFilePath);
            try {
                if (newFile.createNewFile()) {
                    System.out.println("Empty file " + newFilePath + " created.");
                } else {
                    System.out.println("Failed to create " + newFilePath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // List files, directories, and files with a specific extension
            File[] filesAndDirs = directory.listFiles();
            if (filesAndDirs != null) {
                for (File item : filesAndDirs) {
                    if (item.isDirectory()) {
                        System.out.println("Directory: " + item.getName());
                    } else {
                        System.out.println("File: " + item.getName());
                        String extension = getFileExtension(item.getName());
                        if (extension != null && extension.equals("txt")) {
                            System.out.println("File with .txt extension: " + item.getName());
                        }
                    }
                }
            }
        }

        private static String getFileExtension(String fileName) {
            int lastDotIndex = fileName.lastIndexOf(".");
            if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
                return null;
            }
            return fileName.substring(lastDotIndex + 1);
        }
    }


