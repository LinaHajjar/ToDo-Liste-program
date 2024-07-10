import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static void hovedMenu(Scanner input, Scanner scan, ArrayList<String> opgaver)throws IOException {
        //ArrayList<String> opgaver = FileHandler.readFromfile(scan);
        System.out.println("------Here is your main menu:------");
        System.out.println("        1. Add a task.");
        System.out.println("        2. Show all the tasks.");
        System.out.println("        3. Modify an existing task.");
        System.out.println("        4. Delete an existing task.");
        System.out.println("        5. return to the main menu.");
        System.out.println("        6. Mark a task as done.");
        System.out.println("        7. End the program. ");

        int choice= UserInput.getIntInputSwitch("choose a number from the menu: ", "wrong input, you should only choose a number between 1 and 7", 1, 7);

        switch (choice){
            case 1: //done
                System.out.println("you chose option 1: Add a task.");
                SwitchMethods.addTask(input, scan, opgaver);
                break;
            case 2: //done
                System.out.println("you chose option 2: Show all the tasks.");
                SwitchMethods.showAllTasks(input, scan, opgaver);
                break;
            case 3: //done
                System.out.println("you chose option 3: Modify an existing task.");
                SwitchMethods.modifyTask(input, scan, opgaver);
                break;
            case 4:
                System.out.println("you chose option 4: Delete an existing task.");
                SwitchMethods.deleteTask(input,scan,opgaver);
                break;
            case 5: //done
                System.out.println("you chose option 5: Return to main menu.");
                hovedMenu(input,scan, opgaver);
                break;
            case 6:
                System.out.println("you chose option 6: Mark a task as done.");
                SwitchMethods.markDone(input,scan,opgaver);
                break;
            case 7: //done
                System.out.println("you chose option 7: End the program.");
                System.exit(0);
                break;
            default:
                break;
        }
    }
}

