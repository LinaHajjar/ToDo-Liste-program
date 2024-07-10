import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        Scanner input= new Scanner(System.in);
        Scanner scan=new Scanner(new File("src/opgaverFil"));
        ArrayList<String> opgaver = FileHandler.readFromfile(scan);
        /*for (String s: opgaver){
            System.out.println(s);
        }*/
        UI.hovedMenu(input, scan, opgaver);
    }
}
