import java.io.IOException;
import java.nio.file.*;
import java.util.*;
public class DirectoryWatcher {


        public static void main(String[] args) {
            Path directoryToWatch = Paths.get("your_directory_path_here");
            int entryCount = countEntries(directoryToWatch);

            System.out.println("Initial entry count: " + entryCount);

            try {
                WatchService watchService = FileSystems.getDefault().newWatchService();
                directoryToWatch.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

                while (true) {
                    WatchKey key;
                    try {
                        key = watchService.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }

                    for (WatchEvent<?> event : key.pollEvents()) {
                        Path entry = (Path) event.context();
                        if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                            System.out.println("New entry created: " + entry);
                            entryCount++;
                        } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                            System.out.println("Entry deleted: " + entry);
                            entryCount--;
                        }
                    }

                    key.reset();
                    System.out.println("Updated entry count: " + entryCount);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static int countEntries(Path directory) {
            try {
                return (int) Files.walk(directory)
                        .filter(path -> Files.isRegularFile(path) || Files.isDirectory(path))
                        .count();
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }


