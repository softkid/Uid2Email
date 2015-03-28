import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by George on 3/28/2015.
 */

public class GUI extends JFrame {

    private JPanel rootPanel;
    private JButton chooseFileButton;
    private JTextField inputFileTextField;
    private JTextField textField2;
    private JButton chooseFolderButton;
    private JProgressBar progressBar1;
    private JButton convertButton;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    private JFileChooser fileChooser;


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

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptForInputFile();
                inputFileTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                Converter.setInputFile(fileChooser.getSelectedFile().getAbsolutePath());
                Converter.scanInput();
                inputTextArea.setText(Converter.input);
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

    public void showUI(){
        setVisible(true);
    }

}
