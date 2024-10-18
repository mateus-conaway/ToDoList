import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList {
    public ArrayList<Task> taskList = new ArrayList<Task>();
    public Scanner scanner = new Scanner(System.in);
    public boolean isMarked;
    public void createTask() {
        int taskNum = taskList.size() + 1;
        String taskName;
        System.out.println("Task Name: ");
        taskName = scanner.nextLine();
        Task newTask = new Task(taskNum, taskName, false);
        taskList.add(newTask);
    }

    public void viewTasks() {
        System.out.println("To Do List\n----------------------------------------------------------");
        if (taskList.size() == 0) {
            System.out.println("There are no tasks to complete.");
        }
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }

    public void viewUnfinishedTasks() {
        System.out.println("Tasks To Be Completed\n----------------------------------------------------------");
        for (Task task : taskList) {
            if (task.getMarked() == false) {
                System.out.println(task.toString());
            }
        }
    }

    public void finishTask() {
        int id;
        System.out.println("Enter ID of Finished Task: ");
        id = scanner.nextInt();
        if (id >= taskList.size() || id == 0) {
            System.out.println("Task ID out of range");
        }
        for (Task task : taskList) {
            if (task.getId() == id) {
                if (task.getMarked() == true) {
                    System.out.println("Task already completed");
                }
                task.setMarked();
            }
        }
    }

    public void assignID() {
        int id = 1;
        for (Task task : taskList) {
            if (task.getMarked() == false) {
                task.setId(id);
                id++;
            }
        }
    }

    public void createCSV() {
        File csvFile = new File("data.csv");
        try {
            csvFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCSV() {
        String file = "data.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int taskID = Integer.parseInt(values[0]);
                String taskName = values[1];
                
                if (values[2] == "false") {
                    isMarked = false;
                }
                
                Task task = new Task(taskID, taskName, isMarked);
                taskList.add(task);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("\nThere are no tasks in your To Do List");
        }

    }

    public void writeCSV(){
        String file = "data.csv";
        PrintWriter writer = null;
        assignID();
        try {
            writer = new PrintWriter(file);
            for (Task task : taskList) {
                if (task.getMarked() == false) {
                    writer.println(task.getId() + "," + task.getName() + ",false");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        writer.close();
    }

    public void deleteCSV() {
        File csv = new File("data.csv"); 
        csv.delete();
    }
}
