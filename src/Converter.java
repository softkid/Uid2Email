import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    static String inputFile = "";

    static void scanInput(){
        Scanner scan = null;
        try{
            scan = new Scanner(new FileInputStream(new File(inputFile)));
        }catch(FileNotFoundException e){

        }

        while(scan.hasNextLine())
            input += scan.nextLine() + System.lineSeparator();
    }

    static void Convert(){

        System.out.println("INPUT FILE: " + inputFile);


        System.out.println(output);
    }


    static void setInput(String s){
        input = s;
    }

    static void setInputFile(String s){
        inputFile = s;
    }

    static String getOutput(){
        return output;
    }
}
