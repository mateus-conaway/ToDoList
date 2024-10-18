import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean status = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the ToDoList program! ");
        ToDoList toDoList = new ToDoList();
        toDoList.readCSV();
        toDoList.deleteCSV();
        while (status == true) {
            System.out.println("\nWhat would you like to do?\n----------------------------------------------------------\n");
            System.out.println("1) Create Task");
            System.out.println("2) View Tasks");
            System.out.println("3) View Unfinished Tasks");
            System.out.println("4) Mark Task as Complete");
            System.out.println("5) Quit\n");
            int option = scanner.nextInt();
            System.out.println();
            
            if (option == 1) {
                toDoList.createTask();
                System.out.println();
            } else if (option == 2) {
                toDoList.viewTasks();
                System.out.println();
            } else if (option == 3) {
                toDoList.viewUnfinishedTasks();
                System.out.println();
            } else if (option == 4) {
                toDoList.finishTask();
                System.out.println();
            } else if (option == 5) {
                toDoList.writeCSV();
                status = false;
            } else {
                System.out.println("Command Out of Range.\n");
            }
        }
        scanner.close();
        System.out.println("Thanks for using the ToDoList program!");
    }    
}
