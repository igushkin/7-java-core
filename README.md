# 7-java-core

Technical specification
===================

It's time to practice! Now you know that without tests it is impossible to check the program and make sure that everything works exactly as intended. The tracker already has a verification code — it is contained in the `main` methods. Based on this code, you will have to write tests for managers and tasks.

Also in this sprint, you will add new functionality: the application will be able to prioritize tasks and check if they overlap in execution time. Go ahead!

### Add JUnit to the project

Before you start writing tests, add JUnit support to the project. To do this, follow these steps in IntelliJ IDEA.

1. Open any class, for example `Epic'.
2. Press Ctrl+Shift+T. In the drop-down menu, select **Create test** (English "Create test"). In the window that appears, click **OK** — the test will be placed in the same folder.

![image](https://pictures.s3.yandex.net:443/resources/S7_09_1646136854.png)

3. In the test selection menu (**Testing library**), select **JUnit5**, and then click **Fix** (English "Fix").

![image](https://pictures.s3.yandex.net:443/resources/S7_10_1646136889.png)

4. Download the library to the **lib** folder. Check the box next to the item **Download to** (Eng. "Download to...") and click the **OK** button to confirm the creation of the test.

![image](https://pictures.s3.yandex.net:443/resources/S7_11_1646136923.png)

5. After that, the **EpicTest** file will open. You can proceed to writing tests.


💡 Check that all libraries have loaded into the lib folder.

![image](https://pictures.s3.yandex.net:443/resources/S7_12_1646137005.png)

### Cover the code with tests

Your goal is to write a separate test for each public method: a standard case of its operation and boundary cases.

The following tests will be required.

1. To calculate the `Epic` status. Boundary conditions:

a. An empty list of subtasks.

b. All subtasks with the status `NEW'.

c. All subtasks with the status `DONE'.

d. Subtasks with the statuses `NEW` and `DONE'.

e. Subtasks with the status `IN_PROGRESS'.

2. For two task managers `InMemoryTasksManager` and `FileBackedTasksManager'.
* To avoid code duplication, you need a base class with tests for each method from the `abstract class TaskManagerTest<T extends TaskManager>` interface.
* For subtasks, you need to additionally check for the presence of an epic, and for an epic, you need to calculate the status.
* For each method, you need to check its operation:

a. With standard behavior.

b. With an empty task list.

c. With an invalid task ID (empty and/or non-existent ID).

3. For `HistoryManager' — tests for all interface methods. Boundary conditions:

a. Empty task history.

b. Duplication.

c. Removal from history: beginning, middle, end.

4. Additionally for `FileBackedTasksManager' — checking the work on saving and restoring the state. Boundary conditions:

a. Empty task list.

b. Epic without subtasks.

c. Empty history list.


After writing the tests, check their availability again in the list. Make sure they work.

### Add duration and start date

Add new fields to tasks:

* `duration` — the duration of the task, an estimate of how long it will take in minutes (number);
* `startTime' is the date when the task is supposed to start.
* 'getEndTime()` — task completion time, which is calculated based on `startTime` and `duration'.

There is no need to change the signatures of the methods of the `TaskManager` interface: when creating or updating tasks, all its methods will accept and return an object to which you will add two new fields.

You will have to work with the `Epic` class additionally. The duration of an epic is the sum of the duration of all its subtasks. The start time is the start date of the earliest subtask, and the end time is the end time of the latest of the tasks. The new fields `duration` and `startTime` of this class will be calculated — similar to the status field. To implement `getEndTime()`, it is convenient to add the `endTime` field to `Epic` and calculate it together with other fields.

Don't forget to also modify the option to save the state to a file: add new fields to the serialization.

Add validation of new fields to the tests.

### Display the list of tasks in order of priority

Sort all tasks by priority — that is, by `startTime'. If no start date is set, add the task to the end of the list of tasks, subtasks sorted by `startTime`. Write a new method `getPrioritizedTasks` that returns a list of tasks and subtasks in the specified order.

It is assumed that the user will often request this list of tasks and subtasks, so choose a suitable data structure for storage. The difficulty of obtaining should be reduced with `O(n log n)` to `O(n)'.

### Check the intersections

It is assumed that the user will perform no more than one task at a time. Teach the tracker to check that tasks and subtasks do not overlap in execution time. Add validation during the creation or modification of tasks, subtasks.

### Additional task\*

And now an optional task for those who want to challenge themselves! Think about which data structure and which validation algorithm are suitable to reduce the complexity of finding intersections to `O(1)'.

Don't forget to double-check the code before sending it for review!

Have fun programming!
