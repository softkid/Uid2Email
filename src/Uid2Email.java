import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by George on 3/28/2015.
 */

public class Uid2Email {

    private final GUI ui;

    /*private UserInterface ui;*/


    public Uid2Email(){
       ui = new GUI();
    }


    public void start(){
        ui.getConvertButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Converter.setInput(ui.getInputTextArea().getText());
                Converter.Convert();
                ui.getOutputTextArea().setText(Converter.getOutput());
            }
        });

        ui.showUI();


    }

    public static void main(String[] args){
        new Uid2Email().start();
    }
}
