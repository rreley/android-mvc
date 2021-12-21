package com.ualr.simpletasklist.model;

import java.util.HashMap;
import java.util.Map;

public class TaskList {

    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.

    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object
    private final Map<Integer, Task> taskList;

    public TaskList() {
        taskList = new HashMap<>();
    }

    // TODO 04. Define the class constructor and the corresponding getters and setters.
    public String getTaskDescription(Integer id) {
        Task description = this.taskList.get(id);
        return description.getTaskDescription();
    }
    public String getTaskDone(Integer id) {
        Task done = this.taskList.get(id);
        return done.getTaskDone();
    }
    public void setTaskDescription(Integer id) {
        Task done = this.taskList.get(id);
        done.setTaskDescription("");
    }
    public void setTaskDone(Integer id) {
        Task done = this.taskList.get(id);
        done.setTaskDone("Done");
    }

    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.
    public void add(String taskDescription) {
        Task newTask = new Task(taskDescription);
        Integer task = taskList.size() + 1;
        this.taskList.put(task, newTask);
    }

    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line
    public String toString() {
        String x = "";
        String y;
        Integer z =  this.taskList.size();
        while(z !=0)
        {
            y = this.getTaskDone(z);
            x += z.toString() + "-" + this.getTaskDescription(z) + "                         " + y + "\n";
            z--;
        }
        return x;
    }

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.
    public void delete (String id) {
        int taskId = Integer.parseInt(id);
        this.taskList.remove(taskId);
    }

    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.
    public void markDone(Integer id){
        this.setTaskDone(id);
    }

}
