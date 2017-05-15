/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemsetCreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author mes
 */
class ToArffformat {

    File f = null;
    public String directory_name = null;
    File fileToSave = null;
    String fileToSave2 = null;
    String path = null;
    String venue_name_from_file = null;
      int response ;
    ///for stadium option
    String relation = "@relation ";
    String[] stadiums = {"FR1", "FR2", "FR3", "FR4", "FR5", "M1", "M3"};
    String attrib1 = "@attribute Stadium1 {FR1, FR2, FR3, FR4, FR5, M1, M3}";
    String attrib2 = "@attribute Stadium2 {FR1, FR2, FR3, FR4, FR5, M1, M3}";
    String attrib3 = "@attribute Stadium3 {FR1, FR2, FR3, FR4, FR5, M1, M3}";
    String attrib4 = "@attribute Stadium4 {FR1, FR2, FR3, FR4, FR5, M1, M3}";
    String attrib5 = "@attribute Stadium5 {FR1, FR2, FR3, FR4, FR5, M1, M3}";
    String attrib6 = "@attribute Stadium6 {FR1, FR2, FR3, FR4, FR5, M1, M3}";
    String attrib7 = "@attribute Stadium7 {FR1, FR2, FR3, FR4, FR5, M1, M3}";
    String data = "@data";
    ///for gamestage option
    String[] gamestage = {"Group", "QuarterFinal", "ThirdFourth", "SemiFinal"};
    String stage1 = "@attribute stage1 {Group, QuarterFinal, SemiFinal, ThirdFourth}";
    String stage2 = "@attribute stage2 {Group, QuarterFinal, SemiFinal, ThirdFourth}";
    String stage3 = "@attribute stage3 {Group, QuarterFinal, SemiFinal, ThirdFourth}";
    String stage4 = "@attribute stage4 {Group, QuarterFinal, SemiFinal, ThirdFourth}";
    ///for gameseen option
    String[] whichgame = {"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10",
        "G11", "G12", "G13", "G14", "G15", "G16", "G17", "G18", "G19",
        "G20", "G21", "G22", "G23", "G24", "G25", "G26", "M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10",
        "M11", "M12", "M13", "M14", "M15", "M16", "M17", "M18", "M19",
        "MG20", "M21", "M22", "M23", "M24", "M25", "M26", "M27", "M28", "M29", "M30", "M31", "M32"};
    String allgames="{G1, G2, G3, G4, G5, G6, G7, G8, G9, G10, G11, G12, G13, G14, G15, G16, G17, G18,"
            + " G19, G20, G21, G22, G23, G24, G25, G26,"
            + " M1, M2, M3, M4, M5, M6, M7, M8, M9, M10, M11, M12, M13, M14, M15, M16, M17, M18, M19, M20, M21, M22, M23,"
            + " M24, M25, M26, M27, M28, M29, M30, M31, M32}";
    String gamu1 = "@attribute gamu1 "+allgames;
    
    
    List valid = Arrays.asList(stadiums);
    List stagelist = Arrays.asList(gamestage);

    public static void main(String[] args) throws IOException {
        new ToArffformat().initConsole();
    }

    private void initConsole() throws IOException {
        JFileChooser chooser = new JFileChooser("C:\\Users\\mes\\Desktop");
        chooser.addChoosableFileFilter(null);
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();
        directory_name = f.getAbsolutePath();
         String[] options = new String[]{"which Game", "Game stage", "Place"};
              response = JOptionPane.showOptionDialog(null, " ", "Select Itemset for Option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        destination();
    }

    public void destination() throws IOException {
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\mes\\Desktop");
        fileChooser.setDialogTitle("Specify a file to save");
        venue_name_from_file = FilenameUtils.removeExtension(f.getName());
        fileToSave2 = venue_name_from_file + ".arff";
        fileChooser.setSelectedFile(new File(fileToSave2));
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();

            path = fileToSave.getAbsolutePath();
            run();
        }
    }

    public void run() throws IOException {
        BufferedReader br = null;
        BufferedWriter outr = null;
        String line = null;
        File fileOut = new File(path);
        String cvsSplitBy = ",";
        String unknown = "?";
        int i, j;
        boolean firstline = true;

        outr = new BufferedWriter(new FileWriter(fileOut));
        br = new BufferedReader(new FileReader(f));

        String[] userline;
        List answerline = null;
        while ((line = br.readLine()) != null) {
            if (firstline) {
                firstline = false;
                if(response==0){                 
                }
                if(response==2){
                outr.write(relation + venue_name_from_file + "\n" + attrib1 + "\n" + attrib2 + "\n" + attrib3 + "\n" + attrib4 + "\n" + attrib5 + "\n" + attrib6 + "\n" + attrib7 + "\n" + data+ "\n");
                }
                if(response==1){
                outr.write(relation + venue_name_from_file + "\n" + stage1 + "\n" + stage2 + "\n" + stage3 + "\n" + stage4 +"\n" + data+ "\n");
                }
            }
            answerline = new ArrayList<String>();
            userline = line.split(cvsSplitBy);
            j = userline.length;
            System.err.println("array length is=" + j);
            
            if(response==1){                 
                
            for (i = 0; i < 4; i++) {
                if (i < j) {
                    if (stagelist.contains(userline[i].trim())) {
                        answerline.add(userline[i]);
                    } else {
                        System.err.println("we got some probles");
                    }
                } else {
                    answerline.add(unknown);
                }
            }
            }
            if(response==2){                 
                
            for (i = 0; i < 7; i++) {
                if (i < j) {
                    if (valid.contains(userline[i].trim())) {
                        answerline.add(userline[i]);
                    } else {
                        System.err.println("we got some probles");
                    }
                } else {
                    answerline.add(unknown);
                }
            }
            }
            String value = answerline.toString().replace("[", "").replace("]", "");
            outr.write(value);
            outr.newLine();
            outr.flush();
        }
    }
}
