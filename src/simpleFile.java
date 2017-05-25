import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by abhinavdas on 2/18/17.
 */
public class simpleFile {
    public static void fileReadWrite()
    {
        String numFile = "/Users/abhinavdas/Desktop/umn_foursquare_datasets/num.txt";
        Scanner scan;


        try {

            int count = 0;
            scan = new Scanner(new File(numFile));
            String[] line = scan.nextLine().split(" ");
                count = Integer.parseInt(line[line.length-1]);

            int j = 1;


            count = count + 4500;

            FileWriter fw = new FileWriter(new File(numFile),true);
            fw.write( " " + count);
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String []  args)
    {
        fileReadWrite();
    }
}
