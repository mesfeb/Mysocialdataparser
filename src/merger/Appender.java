/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merger;

/**
 *
 * @author mes
 */
import itemsetCreator.TimeStamping;
import java.io.*;
import java.text.ParseException;
import javax.swing.JFileChooser;
import parserjava.CSV_Generator;
import org.apache.commons.io.FilenameUtils;

public class Appender {

    private BufferedReader console; // used to prompt users for input
    private File directory; // directory containing cvs files
    private File[] files;     // all cvs files in a given directory
    private String fileName = null;
    public String folder = null;
    public String directory_name = null;
    File f = null;
    CSV_Generator csvg = new CSV_Generator();

    public Appender() throws ParseException {
        initConsole();
        if ("".equals(folder)) {
            this.directory = new File(System.getProperty("user.dir"));
        } else {
            this.directory = new File(folder);
        }
        if (this.directory.exists() && this.directory.isDirectory()) {
            if (!this.directory.canRead() && !this.directory.canWrite()) {
                System.exit(-100);
            }
//            System.out.println("minew jal+++++++++++");
            this.readSelectedDirectory();
            this.readAndAppend();
        } else {
            System.exit(-100);
        }
    }

    public void readSelectedDirectory() {
        System.out.println("Now Working in: " + this.directory.getAbsolutePath());
        this.files = this.directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".csv");
            }
        });
        if (files.length < 2) {
            for (File x : files) {
                System.out.println("single file cant merge no of files=" + x.getName().toUpperCase());
            }
        }
    }

    private void readAndAppend() throws ParseException {
        File fileOut = new File(this.directory, fileName);
        // if file exists...delete it...so it is ready for a fresh input
        if (fileOut.exists()) {
            fileOut.delete();
        } //-- end if block
        // now create it 
        try {
            fileOut.createNewFile();
        } //-- ends try block
        catch (IOException err) {
            err.printStackTrace(System.err);
        } //-- ends catch block 
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(fileOut, true));
            int i = 0;
            int j;
            for (File input : this.files) {
                if (fileName.equalsIgnoreCase(input.getName())) {
                    continue;
                }
                j = 0;
                BufferedReader in = null;
                try {
                    TimeStamping tst = new TimeStamping();
                    in = new BufferedReader(new FileReader(input));
//                    System.out.println("++ Now reading: '" + input.getName() + "'");
                    String znameoffilebeingread = input.getName();
                    String venue_name_from_file = FilenameUtils.removeExtension(input.getName());
                    String Stage_of_game = directory_name.substring(directory_name.lastIndexOf(".") + 1);
//                 System.out.println("++ stage of the game for these folder is: '" + Stage_of_game + "'");
                    String txt = null;
                    while ((txt = in.readLine()) != null) {
                        if (i == 1 && j == 0) {
                            j++;

                            continue;
                        }
                        //all condition except inside curlybrass  to becommented for normal merging
//                        if (i == 0) {
                            out.write(txt);
//                        }
                        // all if condition to becommented for normal merging
//                        if (i == 1) {
//                            String gameid = tst.timuka(txt, venue_name_from_file, directory_name);
//                            out.write(txt + "," + venue_name_from_file + "," + Stage_of_game + "," + gameid);
//                        }
                        out.newLine();
                        out.flush();
                        i = 1;
                        j++;
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        } catch (FileNotFoundException err) {
            System.out.println("ABEKAKA YIHEWNEW SHIGRU APPENDER777777777777777777777777777777777777777777777**********=");
            err.printStackTrace(System.err);

        } catch (IOException err) {
            err.printStackTrace(System.err);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ignored) {
            }
        }
    }

    private void initConsole() {
        JFileChooser chooser = new JFileChooser("F:\\Thesis\\filtered RIo olympic data with location\\geo");
        chooser.addChoosableFileFilter(null);
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();

        folder = f.getParent();
        directory_name = f.getParentFile().getName();
        fileName = f.getParentFile().getName() + "_All_merge.csv";
    }

    public static void main(String[] args) throws ParseException {
        new Appender();
    }

}
