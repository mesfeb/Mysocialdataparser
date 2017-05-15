/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mes
 */
public class Parserjava {

    /**
     * @param args the command line arguments public static void main(String[]
     * args) { // TODO code application logic here }
     */
//    public static void main(String[] args) throws Exception {}
    public void mains(File f) throws Exception {
        JsonFlattener parser = new JsonFlattener();
        CSVWriter writer = new CSVWriter();
        String filename = f.getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<List<Map<String, String>>> all = new ArrayList<List<Map<String, String>>>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            // do stuff to file here  
            List<Map<String, String>> flatJson = parser.parseJson(line);
            all.add(flatJson);

        }
        try {

            CSV_Generator vv = new CSV_Generator();
            String dude = vv.destination();

            writer.writeAsCSV(all, dude);
        } catch (Exception e) {
        }
    }
}
