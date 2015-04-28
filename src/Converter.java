import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by George on 3/28/2015.
 */
public class Converter {

    private static Converter instance = new Converter();

    public static Converter getInstance() {
        return instance;
    }

    private Converter() {

        // Empty to Avoid instantiation
    }



    static ArrayList<String> inputList = new ArrayList<String>();

    private static boolean extractFromUrl = false;

    static String input = "";
    static String output = "";
    static String inputFile = "";

    private static int lineCount = 0;

    static void scanInput(){
        Scanner scan = null;
        try{
            scan = new Scanner(new FileInputStream(new File(inputFile)));
        }catch(FileNotFoundException e){

        }

        while(scan.hasNextLine()) {
            input += scan.nextLine() + System.lineSeparator();
            lineCount++;
        }
    }

    static void Convert(){
        if(extractFromUrl) inputList = extractInputFromUrl(inputList);

        System.out.println("INPUT FILE: " + inputFile);

        Scanner scan = new Scanner(input);
        while(scan.hasNextLine())
            output += scan.nextLine() + "@facebook.com" + System.lineSeparator();

        System.out.println(output);
    }

    private static ArrayList<String> extractInputFromUrl(ArrayList<String> input){
        // Convert input from string to URL
        // Create new UrlUidExtractor
        // Return <String> ArrayList
        return null;
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

    static int getLineCount(){return lineCount;}


    public static void setExtractFromUrl(boolean b){
        extractFromUrl = b;
    }

    public static boolean getExtractFromUrl(){
        return extractFromUrl;
    }


    static void clearIO(){
        input = "";
        output = "";
    }
}
