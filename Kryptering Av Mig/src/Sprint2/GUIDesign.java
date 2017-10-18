package Sprint2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by sjjo15 on 2017-10-04.
 */
public class GUIDesign extends JFrame {
    private JLabel inputFileLabel = new JLabel("Input File");
    public static JTextField inputFile = new JTextField(10);
    private JButton inputBrowse = new JButton("Browse");
    private JLabel keyFileLabel = new JLabel("Key File");
    public static JTextField keyFile = new JTextField(10);
    private JButton keyInputBrowse = new JButton("Browse");
    private JLabel outputFileLabel = new JLabel("Output file");
    private JTextField outputFile = new JTextField(10);
    private JButton outputBrowse = new JButton("Browse");
    public static JButton goButton = new JButton("Go");
    JRadioButton encryptButton = new JRadioButton("Encrypt");
    JRadioButton decryptButton = new JRadioButton("Decrypt");
    ButtonGroup group = new ButtonGroup();

    GUIDesign() {
        // Sets up the view and adds the components
        JPanel guiPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        guiPanel.add(inputFileLabel);
        inputFile.setEditable(false);
        guiPanel.add(inputFile);
        guiPanel.add(inputBrowse);
        guiPanel.add(keyFileLabel);
        keyFile.setEditable(false);
        guiPanel.add(keyFile);
        guiPanel.add(keyInputBrowse);
        guiPanel.add(outputFileLabel);
        outputFile.setEditable(false);
        guiPanel.add(outputFile);
        guiPanel.add(outputBrowse);

        encryptButton.setMnemonic(KeyEvent.VK_E);
        encryptButton.setSelected(true);
        decryptButton.setMnemonic(KeyEvent.VK_D);
        group.add(encryptButton);
        group.add(decryptButton);
        guiPanel.add(encryptButton);
        guiPanel.add(decryptButton);
        guiPanel.add(goButton);

        //Input File Chooser Action Listener
        inputBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser inputFileChooser = new JFileChooser();
                int answer = inputFileChooser.showOpenDialog(null);
                if(answer == JFileChooser.APPROVE_OPTION) {
                    File f = inputFileChooser.getSelectedFile();
                    String fname = f.getPath();
                    inputFile.setText(fname.substring(fname.lastIndexOf("\\") + 1, fname.length()));
                }
                inputFileChooser.setVisible(true);
            }
        });

        //Key File Chooser Action Listener
        keyInputBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser keyInputFileChooser = new JFileChooser();
                int answer = keyInputFileChooser.showOpenDialog(null);
                if(answer ==JFileChooser.APPROVE_OPTION){
                    File f = keyInputFileChooser.getSelectedFile();
                    String fname = f.getPath();
                    keyFile.setText(fname.substring(fname.lastIndexOf("\\") + 1, fname.length()));
                }
                keyInputFileChooser.setVisible(true);
            }
        });

        //Output File Chooser Action Listener
        outputBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser outputFileChooser = new JFileChooser();
                int answer = outputFileChooser.showOpenDialog(null);
                if(answer == JFileChooser.APPROVE_OPTION){
                    File file = outputFileChooser.getSelectedFile();
                    String fname = file.getPath();
                    outputFile.setText(fname.substring(fname.lastIndexOf("\\") + 1, fname.length()));
                }
            }
        });

        //Packing of GUI
        this.setResizable(false);
        this.add(guiPanel);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        GUIDesign gui = new GUIDesign();
        gui.setVisible(true);
    }

    public void goButtonAct(ActionListener a){
        goButton.addActionListener(a);
    }
}
