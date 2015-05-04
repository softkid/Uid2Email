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
    static ArrayList<String> outputList = new ArrayList<String>();

    private static boolean extractFromUrl = false;

    private static String input = "";
    private static String output = "";
    private static String inputFile = "";


    private static int duplicates = 0;

    static void scanInputFromFile(){
        Scanner scan = null;
        try{
            scan = new Scanner(new FileInputStream(new File(inputFile)));
        }catch(FileNotFoundException e){

        }

        while(scan.hasNextLine()) {
            inputList.add(scan.nextLine() + System.lineSeparator());
        }
    }

    static void scanInputManual(String input){
        Scanner in = new Scanner(input);
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(inputList.contains(line)){duplicates++; continue;}
            inputList.add(line);
        }
        System.out.println("Removed, "  + duplicates + " duplicates!");


    }

    static void Convert(){
        if(extractFromUrl) inputList = extractInputFromUrl(inputList);

        System.out.println("INPUT FILE: " + inputFile);

        int counter = 0;
        for(String input : inputList){
            counter++;
            outputList.add(input + "@facebook.com" + System.lineSeparator());
            if(counter % 15 == 0) Uid2Email.updateProgressBar();
        }
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

    static int getLineCount(){return inputList.size();}

    static String getPrintableInput(){
        String result = "";
        for(String input: inputList){
            result += input;
        }
        return result;
    }

    static String getPrintableOutput(){
        String result = "";
        for(String output : outputList){
            result += output;
            System.out.println(output);
        }
        return result;
    }


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
