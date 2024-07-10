import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SwitchMethods {
    public static void addTask(Scanner input, Scanner scan, ArrayList<String>opgaver) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("src/opgaverFil"));
        System.out.println("write the task you want to add: ");
        String newTask = input.nextLine();
        opgaver.add(newTask);
        for (String s : opgaver) {
            out.write(s + "\n");
        }
        out.close();
        System.out.println("Do you want to add more tasks? yes / no");
        String answer = input.nextLine();
        if (UserInput.containsIgnoreCase("yes", answer)) {
            addTask(input, scan, opgaver);
        } else {
            System.out.println("Returning to the main menu:");
            UI.hovedMenu(input, scan, opgaver);
        }
    }
    public static void showAllTasks(Scanner input, Scanner scan, ArrayList<String>opgaver)throws IOException{
        for (int i=0; i<opgaver.size(); i++){
            System.out.print("opgaver nr. " + (i+1)+ ": ");
            System.out.println(opgaver.get(i));
            System.out.println();
        }
        System.out.println("Returning to the main menu:");
        UI.hovedMenu(input,scan,opgaver);
    }

    public static void modifyTask(Scanner input, Scanner scan, ArrayList<String> opgaver) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("src/opgaverFil"));

        int nbModifyTask= UserInput.getIntInputSwitch("write the number of the task you want to modify: ", "wrong input, you chose a wrong number, try again",1, opgaver.size());
        //input.nextLine();
        String taskModify= "";
        int index=0;

        for(int i=0; i<opgaver.size(); i++){
            if (nbModifyTask-1==i){
                taskModify=opgaver.get(i);
                index=i;
                break;
            }
        }
        System.out.println("you chose to modify this task: " + taskModify);
        System.out.println("is this right? yes / no");
        String answer = input.nextLine();
        if (UserInput.containsIgnoreCase("no",answer)){
            System.out.println("Start again");
            modifyTask(input, scan, opgaver);
        } else {
            System.out.println("write the new task");
            String newTask=input.nextLine();
            opgaver.set(index,newTask);
        }
        for (String s : opgaver) {
            out.write(s + "\n");
        }
        out.close();
        System.out.println("Do you want to modify more tasks? yes / no");
        String answer2 = input.nextLine();
        if (UserInput.containsIgnoreCase("yes", answer2)) {
            modifyTask(input,scan, opgaver);
        } else {
            System.out.println("Returning to the main menu:");
            UI.hovedMenu(input, scan, opgaver);
        }
    }

    public static void deleteTask(Scanner input, Scanner scan, ArrayList<String>opgaver) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("src/opgaverFil"));

        int nbDeleteTask= UserInput.getIntInputSwitch("write the number of the task you want to delete: ", "wrong input, you chose a wrong number, try again",1, opgaver.size());
        int index=0;
        for(int i=0; i<opgaver.size(); i++){
            if (nbDeleteTask-1==i){
                index=i;
                break;
            }
        }
        System.out.println("you chose to modify this task: " + opgaver.get(index));
        System.out.println("is this right? yes / no");
        String answer = input.nextLine();
        if (UserInput.containsIgnoreCase("no",answer)){
            System.out.println("Start again");
            deleteTask(input, scan, opgaver);
        } else {
            opgaver.remove(index);
        }
        for (String s : opgaver) {
            out.write(s + "\n");
        }
        out.close();
        System.out.println("Do you want to remove more tasks? yes / no");
        String answer2 = input.nextLine();
        if (UserInput.containsIgnoreCase("yes", answer2)) {
            deleteTask(input,scan, opgaver);
        } else {
            System.out.println("Returning to the main menu:");
            UI.hovedMenu(input, scan, opgaver);
        }
    }

    public static void markDone(Scanner input,Scanner scan, ArrayList<String>opgaver)throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("src/opgaverFil"));

        int nbDoneTask= UserInput.getIntInputSwitch("write the number of the task you want to mark as done: ", "wrong input, you chose a wrong number, try again",1, opgaver.size());
        int index=0;
        for(int i=0; i<opgaver.size(); i++){
            if (nbDoneTask-1==i){
                index=i;
                break;
            }
        }
        System.out.println("you chose to mark this task as done: " + opgaver.get(index));
        System.out.println("is this right? yes / no");
        String answer = input.nextLine();
        if (UserInput.containsIgnoreCase("no",answer)){
            System.out.println("Start again");
            markDone(input, scan, opgaver);
        } else {
            String opgaveDone= opgaver.get(index) + " : Done.";
            opgaver.set(index,opgaveDone);
        }
        for (String s : opgaver) {
            out.write(s + "\n");
        }
        out.close();
        System.out.println("Do you want to mark more tasks as done? yes / no");
        String answer2 = input.nextLine();
        if (UserInput.containsIgnoreCase("yes", answer2)) {
            markDone(input,scan, opgaver);
        } else {
            System.out.println("Returning to the main menu:");
            UI.hovedMenu(input, scan, opgaver);
        }
    }
}
