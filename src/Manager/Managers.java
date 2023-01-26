package Manager;

import Task.Task;

import java.nio.file.Path;

public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static TaskManager getFileBackedManager(Path path){
        return new FileBackedTasksManager(path);
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
