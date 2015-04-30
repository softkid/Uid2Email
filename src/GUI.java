import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.net.URL;


/**
 * Created by George on 3/28/2015.
 */

public class GUI extends JFrame {

    private JPanel rootPanel;
    private JButton chooseFileButton;
    private JTextField inputFileTextField;
    private JTextField outputFolderTextField;
    private JButton chooseFolderButton;
    private JProgressBar progressBar;
    private JButton convertButton;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton clearAllButton;
    private JButton exportToCsvButton;
    private JButton exportToTxtButton;
    private JButton exportToXlsButton;
    private JLabel counterLabel;
    private JButton copyToClipboardButton;
    private JLabel percentageLabel;
    private JLabel outputFolderLabel;
    private JLabel inputFileLabel;
    private JTextField outputFileNameTextField;
    private JEditorPane googleAddEditorPane;
    private JRadioButton UIDsRadioButton;
    private JRadioButton URLsRadioButton;

    private ButtonGroup radioGroup;

    private JFileChooser fileChooser;
    private JFileChooser folderChooser;
    private ImageIcon img;

    private URL url;

    private FileType outputFileType;

    private int percentageCompleted = 0;


    public GUI() {
        super("Uid2Email Converter");
        img = new ImageIcon("assets/icons/icon-small.png"); //Title bar icon
        init();
    }


    void init() {
        googleAddEditorPane.setText("Google AD Banner!");
        setContentPane(rootPanel);
        setSize(750, 750);
        setMinimumSize(new Dimension(680, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(img.getImage());


        url = ClassLoader.getSystemResource("assets/icons/icon-small.png");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Look and Feel Problem");
        }

        outputFileNameTextField.setText("Output file name");
        outputFileNameTextField.setToolTipText("Set the output file name");

        Font font = new Font("Verdana", Font.ITALIC, 12);
        outputFileNameTextField.setFont(font);


        outputFileNameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                outputFileNameTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                outputFileNameTextField.setText("Output file name");
            }
        });

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptForInputFile();
                inputFileTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                Converter.setInputFile(fileChooser.getSelectedFile().getAbsolutePath());
                Converter.scanInputFromFile();
                counterLabel.setText(String.valueOf(Converter.getLineCount()));
                inputTextArea.setText(Converter.getPrintableInput());
            }
        });

        chooseFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptForOutputFolder();
                outputFolderTextField.setText(folderChooser.getSelectedFile().getAbsolutePath());
            }
        });

        inputTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                Converter.scanInputManual(inputTextArea.getText());
            }
        });




        // Action: Press Convert Button
        convertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //Show Loading Cursor
                rootPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                //Convert
                Converter.Convert();

                //Display output
                outputTextArea.setText(Converter.getPrintableOutput());

                //Change back to default Cursor
                rootPanel.setCursor(Cursor.getDefaultCursor());
            }
        });

        radioGroup = new ButtonGroup();
        radioGroup.add(UIDsRadioButton);
        radioGroup.add(URLsRadioButton);

        URLsRadioButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Converter.setExtractFromUrl(true);
                System.out.println(Converter.getExtractFromUrl());
            }
        });

        UIDsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Converter.setExtractFromUrl(false);
                System.out.println(Converter.getExtractFromUrl());
            }
        });

        outPutFileSettings();

    }

    public void outPutFileSettings(){
        exportToTxtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputFileType = FileType.TXT;
                System.out.println("Writting to txt");
            }
        });

        exportToCsvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputFileType = FileType.CSV;
                System.out.println("Writting to csv");
            }
        });

        exportToXlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputFileType = FileType.XLS;
                System.out.println("Writting to xls");
            }
        });
    }




    public JButton getConvertButton(){
        return this.convertButton;
    }

    public JTextArea getInputTextArea(){
        return this.inputTextArea;
    }

    public JTextArea getOutputTextArea(){
        return this.outputTextArea;
    }

    public JTextField getInputFileTextField(){
        return this.inputFileTextField;
    }

    public void promptForInputFile() {
        fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("Choose a file");

        fileChooser.showOpenDialog(this);

        System.out.println(fileChooser.getSelectedFile().getAbsolutePath());

    }

    public void promptForOutputFolder(){
        folderChooser= new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setDialogTitle("Choose output folder");
        folderChooser.showOpenDialog(this);


        System.out.println(folderChooser.getSelectedFile().getAbsolutePath());

    }

    /**
     * Progress Bar methods
     */

    public int getProgress(){
        return percentageCompleted;
    }

    public void setProgress(int percentageCompleted){
        this.percentageCompleted = percentageCompleted;
    }

    public void showUI(){
        setVisible(true);
    }


}
