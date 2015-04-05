import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


/**
 * Created by George on 3/28/2015.
 */

public class GUI extends JFrame {

    private JPanel rootPanel;
    private JButton chooseFileButton;
    private JTextField inputFileTextField;
    private JTextField outputFileTextField;
    private JButton chooseFolderButton;
    private JProgressBar progressBar;
    private JButton convertButton;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton clearAllButton;
    private JButton exportToCsvButton;
    private JButton exportToTxtButton;
    private JLabel counterLabel;
    private JButton exportToXlsButton;
    private JButton copyToClipboardButton;
    private JLabel percentageLabel;
    private JLabel outputFolderLabel;
    private JLabel inputFileLabel;
    private JTextField outputFileNameTextField;

    private JFileChooser fileChooser;

    private int percentageCompleted = 0;


    public GUI() {
        super("Uid2Email Converter");
        init();
    }


    void init() {
        setContentPane(rootPanel);
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                Converter.scanInput();
                counterLabel.setText(String.valueOf(Converter.getLineCount()));
                inputTextArea.setText(Converter.input);
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
                outputTextArea.setText(Converter.getOutput());

                //Change back to default Cursor
                rootPanel.setCursor(Cursor.getDefaultCursor());
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
