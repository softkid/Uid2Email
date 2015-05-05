import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


/**
 * Created by George on 4/6/2015.
 */
public class WriteToFile {

    private String filePath;
    private String fileName;
    private String outputText;

    private Scanner textScanner;
    private FileWriter writter;


    private boolean fileExists = false;

    public static final int TXT = 1;
    public static final int XLS = 2;
    public static final int CSV = 3;

    private boolean outputFileExists = false;



    public WriteToFile(String filePath, String fileName, String outputText){
        this.filePath = filePath;
        this.fileName = fileName;
        this.outputText = outputText;
    }

    private static final String FILE_HEADER = "uid,email";




}
