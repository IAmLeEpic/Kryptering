package Sprint5;
import Sprint2.GUIDesign;

import javax.swing.*;
import java.io.*;

/**
 * Created by sjjo15 on 2017-09-27.
 */
public class fileCopy {
    public static void main (String[] args) {
        /*String inputFileName = "";
        inputFileName = JOptionPane.showInputDialog(null, "Vad heter filen du vill kopiera?");

        System.out.println("Filen heter " + "\"" + inputFileName + "\"");

        String[] choices = {"Text", "Binärt"};
        String inputChoices = (String) JOptionPane.showInputDialog(null, "Ska filen kopieras som text eller binärt?", "Hej", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        */

        //Öppnar och läser den valda filen
        if (inputChoices.equals("Text")) {
            String filnamn = GUIDesign.inputFile.getText();
            FileWriter fw = null;
            FileReader fr = null;
            FileReader kfr = null;
            try {
                fw = new FileWriter("KopiaAv" + filnamn);
                fr = new FileReader(filnamn);
                kfr = new FileReader(GUIDesign.keyFile.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader inFil = new BufferedReader(fr);
            BufferedReader keyInFil = new BufferedReader(kfr);

            //Läser och skriver i nya filen
            try {
                String x = inFil.readLine();
                String key = keyInFil.readLine();
                while (x != null) {
                    System.out.println(crypt(x,key));
                    pw.println(x);
                    x = inFil.readLine();
                }
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Text vald, fil kopierad!");
        } else if (inputChoices.equals("Binärt")) {

        }
    }

        //Fil Crypt Metod
        public static String crypt(String m, String k){
            String result = "";

            while(k.length() < m.length()){
                k+=k;
            }

            for(int i = 0; i < m.length(); i++){
                result += (char)(m.charAt(i)^k.charAt(i));
            }
            return result;
        }

    }
}
