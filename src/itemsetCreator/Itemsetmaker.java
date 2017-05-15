/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemsetCreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mes
 */
public class Itemsetmaker {
    private String fileName = null;
    public String folder = null;
    public String directory_name = null;
    File f = null;
    File fileToSave = null;
    String path = null;
//    HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
    HashMap<String, Set<String>> hashmap = new HashMap<String, Set<String>>();

    public static void main(String[] args) {
        new Itemsetmaker().run();
    }
    private void initConsole() {
        JFileChooser chooser = new JFileChooser("C:\\Users\\mes\\Desktop\\json-csv\\1fromevery");
        chooser.addChoosableFileFilter(null);
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();
        directory_name = f.getAbsolutePath();
    }

    public void destination() {
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\mes\\Desktop");
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();
            folder = fileToSave.getParent();
//            System.out.println("file to save value is ------" + fileToSave);
            path = fileToSave.getAbsolutePath();
//            System.out.println("path value is ------" + path);
        }
    }
    public void run() {
        BufferedReader br = null;
        initConsole();
        String line = null;
        String jumper = "";
        String cvsSplitBy = ",";
        BufferedWriter outr = null;
        String[] options = new String[]{"which Game", "Game stage", "Place"};
            int response = JOptionPane.showOptionDialog(null, "Select Itemset for ", "Itemset Type", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        destination();
        File fileOut = new File(path);
        try {
            outr = new BufferedWriter(new FileWriter(fileOut));
            br = new BufferedReader(new FileReader(directory_name));
            boolean firstline = true;
            String[] user;
            while ((line = br.readLine()) != null) {
                if (firstline) {
                    firstline = false;
                    continue;
                }
                user = line.split(cvsSplitBy);
                for (String data : user) { 
                    if (response == 0) {
                        if (hashmap.containsKey(user[4])) {
                            Set<String> list = hashmap.get(user[4]);
                            list.add(user[8]);
                            hashmap.put(user[4], list);
                        } else {
                            Set<String> arraylist2 = new TreeSet<String>();
                            arraylist2.add(user[8]);
                            hashmap.put(user[4], arraylist2);
                        }
                    } 
                    if (response == 1) {
                        if (hashmap.containsKey(user[4])) { 
                            Set<String> list = hashmap.get(user[4]);
                            list.add(user[7]);
                            hashmap.put(user[4], list); 
                        } else {
                            Set<String> arraylist2 = new TreeSet<String>();
                            arraylist2.add(user[7]);
                            hashmap.put(user[4], arraylist2);
                        }
                    } 
                    if (response == 2) {
                        if (hashmap.containsKey(user[4])) { 
                            Set<String> list = hashmap.get(user[4]);
                            list.add(user[6]);
                            hashmap.put(user[4], list); 
                        } else {
                            Set<String> arraylist2 = new TreeSet<String>();
                            arraylist2.add(user[6]);
                            hashmap.put(user[4], arraylist2);
                        }
                    }
                }
//                System.out.println(hashmap);
            }
               for (String key : hashmap.keySet()) {  
                    String value = hashmap.get(key).toString().replace("[", "").replace("]", "");
                    outr.write(
//                            key + " " + 
                                    value);
                    outr.newLine();
                    outr.flush();
                }
             System.out.println("loop ove!" );
        } catch (FileNotFoundException e) {
        System.out.println("error"+e);
        } catch (IOException e) {
            System.out.println("error"+e);
        } finally {
             System.out.println("finished" );
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
//                      System.out.println("error"+e);
                }
            }
        }
      
    }
}
