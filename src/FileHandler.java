import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

    public class FileHandler {
        public static ArrayList<String> readFromfile(Scanner scan)throws FileNotFoundException {
            ArrayList<String> opgaver =new ArrayList<>();
            while(scan.hasNextLine()){
                opgaver.add(scan.nextLine());
            }
            return opgaver;
        } // end of readFromfile
    }
