package Tests;

import Manager.InMemoryHistoryManager;
import Manager.Managers;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest extends TaskManagerTest {

    public InMemoryTaskManagerTest() {
        this.manager = Managers.getDefault();
    }
}