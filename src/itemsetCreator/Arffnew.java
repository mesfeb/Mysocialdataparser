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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author mes
 */
public class Arffnew {

    File f = null;
    public String directory_name = null;
    File fileToSave = null;
    String fileToSave2 = null;
    String path = null;
    String venue_name_from_file = null;
    int response;
    ///for stadium option
    String relation = "@relation ";
    String[] stadiums = {"FR1", "FR2", "FR3", "FR4", "FR5", "M1", "M3"};
    String attrib1 = "@attribute FR1 {0, 1}";
    String attrib2 = "@attribute FR2 {0, 1}";
    String attrib3 = "@attribute FR3 {0, 1}";
    String attrib4 = "@attribute FR4 {0, 1}";
    String attrib5 = "@attribute FR5 {0, 1}";
    String attrib6 = "@attribute M1 {0, 1}";
    String attrib7 = "@attribute M3 {0, 1}";
    String data = "@data";
    ///for gamestage option
    String[] gamestage = {"Group", "QuarterFinal", "SemiFinal", "ThirdFourth"};
    String stage1 = "@attribute Group {0, 1}";
    String stage2 = "@attribute QuarterFinal {0, 1}";
    String stage3 = "@attribute SemiFinal {0, 1}";
    String stage4 = "@attribute ThirdFourth {0, 1}";

    ///for gameseen option
    String[] whichgame = {"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10",
        "G11", "G12", "G13", "G14", "G15", "G16", "G17", "G18", "G19",
        "G20", "G21", "G22", "G23", "G24", "G25", "G26",
        "M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10",
        "M11", "M12", "M13", "M14", "M15", "M16", "M17", "M18", "M19",
        "M20", "M21", "M22", "M23", "M24", "M25", "M26", "M27", "M28", "M29", "M30", "M31", "M32"};
    String gamu1 = "@attribute G1 {0, 1}";
    String gamu2 = "@attribute G2 {0, 1}";
    String gamu3 = "@attribute G3 {0, 1}";
    String gamu4 = "@attribute G4 {0, 1}";
    String gamu5 = "@attribute G5 {0, 1}";
    String gamu6 = "@attribute G6 {0, 1}";
    String gamu7 = "@attribute G7 {0, 1}";
    String gamu8 = "@attribute G8 {0, 1}";
    String gamu9 = "@attribute G9 {0, 1}";
    String gamu10 = "@attribute G10 {0, 1}";
    String gamu11 = "@attribute G11 {0, 1}";
    String gamu12 = "@attribute G12 {0, 1}";
    String gamu13 = "@attribute G13 {0, 1}";
    String gamu14 = "@attribute G14 {0, 1}";
    String gamu15 = "@attribute G15 {0, 1}";
    String gamu16 = "@attribute G16 {0, 1}";
    String gamu17 = "@attribute G17 {0, 1}";
    String gamu18 = "@attribute G18 {0, 1}";
    String gamu19 = "@attribute G19 {0, 1}";
    String gamu20 = "@attribute G20 {0, 1}";
    String gamu21 = "@attribute G21 {0, 1}";
    String gamu22 = "@attribute G22 {0, 1}";
    String gamu23 = "@attribute G23 {0, 1}";
    String gamu24 = "@attribute G24 {0, 1}";
    String gamu25 = "@attribute G25 {0, 1}";
    String gamu26 = "@attribute G26 {0, 1}";
    String gamu27 = "@attribute M1 {0, 1}";
    String gamu28 = "@attribute M2 {0, 1}";
    String gamu29 = "@attribute M3 {0, 1}";
    String gamu30 = "@attribute M4 {0, 1}";
    String gamu31 = "@attribute M5 {0, 1}";
    String gamu32 = "@attribute M6 {0, 1}";
    String gamu33 = "@attribute M7 {0, 1}";
    String gamu34 = "@attribute M8 {0, 1}";
    String gamu35 = "@attribute M9 {0, 1}";
    String gamu36 = "@attribute M10 {0, 1}";
    String gamu37 = "@attribute M11 {0, 1}";
    String gamu38 = "@attribute M12 {0, 1}";
    String gamu39 = "@attribute M13 {0, 1}";
    String gamu40 = "@attribute M14 {0, 1}";
    String gamu41 = "@attribute M15 {0, 1}";
    String gamu42 = "@attribute M16 {0, 1}";
    String gamu43 = "@attribute M17 {0, 1}";
    String gamu44 = "@attribute M18 {0, 1}";
    String gamu45 = "@attribute M19 {0, 1}";
    String gamu46 = "@attribute M20 {0, 1}";
    String gamu47 = "@attribute M21 {0, 1}";
    String gamu48 = "@attribute M22 {0, 1}";
    String gamu49 = "@attribute M23 {0, 1}";
    String gamu50 = "@attribute M24 {0, 1}";
    String gamu51 = "@attribute M25 {0, 1}";
    String gamu52 = "@attribute M26 {0, 1}";
    String gamu53 = "@attribute M27 {0, 1}";
    String gamu54 = "@attribute M28 {0, 1}";
    String gamu55 = "@attribute M29 {0, 1}";
    String gamu56 = "@attribute M30 {0, 1}";
    String gamu57 = "@attribute M31 {0, 1}";
    String gamu58 = "@attribute M32 {0, 1}";

    List<String> valid = Arrays.asList(stadiums);
    List<String> stagelist = Arrays.asList(gamestage);
    List<String> wichgames = Arrays.asList(whichgame);

    public static void main(String[] args) throws IOException {
        new Arffnew().initConsole();
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
        int index;

        outr = new BufferedWriter(new FileWriter(fileOut));
        br = new BufferedReader(new FileReader(f));

        String[] userline;
        List answerline = null;
        while ((line = br.readLine()) != null) {
            if (firstline) {
                firstline = false;
                if (response == 0) {
                    outr.write(relation + venue_name_from_file + "\n" + gamu1 + "\n" + gamu2 + "\n" + gamu3 + "\n" + gamu4 + "\n" + gamu5 + "\n" + gamu6 + "\n" + gamu7 + "\n" + gamu8 + "\n" + gamu9 + "\n" + gamu10 + "\n"
                            + gamu11 + "\n" + gamu12 + "\n" + gamu13 + "\n" + gamu14 + "\n" + gamu15 + "\n" + gamu16 + "\n" + gamu17 + "\n" + gamu18 + "\n" + gamu19 + "\n" + gamu20 + "\n"
                            + gamu21 + "\n" + gamu22 + "\n" + gamu23 + "\n" + gamu24 + "\n" + gamu25 + "\n" + gamu26 + "\n" + gamu27 + "\n" + gamu28 + "\n" + gamu29 + "\n" + gamu30 + "\n"
                            + gamu31 + "\n" + gamu32 + "\n" + gamu33 + "\n" + gamu34 + "\n" + gamu35 + "\n" + gamu36 + "\n" + gamu37 + "\n" + gamu38 + "\n" + gamu39 + "\n" + gamu40 + "\n"
                            + gamu41 + "\n" + gamu42 + "\n" + gamu43 + "\n" + gamu44 + "\n" + gamu45 + "\n" + gamu46 + "\n" + gamu47 + "\n" + gamu48 + "\n" + gamu49 + "\n" + gamu50 + "\n"
                            + gamu51 + "\n" + gamu52 + "\n" + gamu53 + "\n" + gamu54 + "\n" + gamu55 + "\n" + gamu56 + "\n" + gamu57 + "\n" + gamu58 + "\n" + data + "\n");
                }

                if (response == 1) {
                    outr.write(relation + venue_name_from_file + "\n" + stage1 + "\n" + stage2 + "\n" + stage3 + "\n" + stage4 + "\n" + data + "\n");
                }
                if (response == 2) {
                    outr.write(relation + venue_name_from_file + "\n" + attrib1 + "\n" + attrib2 + "\n" + attrib3 + "\n" + attrib4 + "\n" + attrib5 + "\n" + attrib6 + "\n" + attrib7 + "\n" + data + "\n");
                }
            }
            answerline = new ArrayList<String>();
            userline = line.split(cvsSplitBy);
            j = userline.length;

            System.err.println("array length is=" + j);
            if (response == 0) {
                for (String currentStage : wichgames) {
                    boolean found = false;
                    for (int l = 0; l < userline.length; l++) {
                        if (currentStage.equals(userline[l].trim())) {
                            answerline.add(1);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        answerline.add(0);
                    }

                }
            }
            if (response == 1) {

                for (String currentStage : stagelist) {
                    boolean found = false;
                    for (int l = 0; l < userline.length; l++) {
                        if (currentStage.equals(userline[l].trim())) {
                            answerline.add(1);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        answerline.add(0);
                    }

                }

            }
            if (response == 2) {
                for (String currentStage : valid) {
                    boolean found = false;
                    for (int l = 0; l < userline.length; l++) {
                        if (currentStage.equals(userline[l].trim())) {
                            answerline.add(1);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        answerline.add(0);
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
