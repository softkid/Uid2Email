import java.util.Scanner;

/**
 * Created by George on 3/28/2015.
 */
public class Converter {
    private static Converter ourInstance = new Converter();

    public static Converter getInstance() {
        return ourInstance;
    }

    private Converter() {

        // Empty to Avoid instantiation
    }

    static String input = "";
    static String output = "";

    static void Convert(){
        Scanner scan = new Scanner(input);
        while(scan.hasNextLine())
            output += scan.nextLine() + System.lineSeparator();

        System.out.println(output);
    }


    static void setInput(String s){
        input = s;
    }

    static String getOutput(){
        return output;
    }
}
