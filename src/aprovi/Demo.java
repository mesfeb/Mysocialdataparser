/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprovi;

/**
 *
 * @author mes
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JFileChooser;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        AprioriFrequentItemsetGenerator<String> generator
                = new AprioriFrequentItemsetGenerator<>();
        File f = null;
        BufferedReader br = null;
        String line = null;
        List<Set<String>> itemsetList = new ArrayList<>();
        JFileChooser chooser = new JFileChooser("C:\\Users\\mes\\Desktop");
        chooser.addChoosableFileFilter(null);
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();
        br = new BufferedReader(new FileReader(f));

        Set<String> userl = null;
        while ((line = br.readLine()) != null) {
//    userline=line.split(cvsSplitBy);
            userl.add(line);

        }
        itemsetList.add(userl);
//        itemsetList.add(new HashSet<>(Arrays.asList("a", "b")));
//        itemsetList.add(new HashSet<>(Arrays.asList("b", "c", "d")));
//        itemsetList.add(new HashSet<>(Arrays.asList("a", "c", "d", "e")));
//        itemsetList.add(new HashSet<>(Arrays.asList("a", "d", "e")));
//        itemsetList.add(new HashSet<>(Arrays.asList("a", "b", "c")));
//
//        itemsetList.add(new HashSet<>(Arrays.asList("a", "b", "c", "d")));
//        itemsetList.add(new HashSet<>(Arrays.asList("a")));
//        itemsetList.add(new HashSet<>(Arrays.asList("a", "b", "c")));
//        itemsetList.add(new HashSet<>(Arrays.asList("a", "b", "d")));
//        itemsetList.add(new HashSet<>(Arrays.asList("b", "c", "e")));

        FrequentItemsetData<String> data = generator.generate(itemsetList, 0.2);
        int i = 1;
        for (Set<String> itemset : data.getFrequentItemsetList()) {
            System.out.printf("%2d: %9s, support: %1.1f\n",
                    i++,
                    itemset,
                    data.getSupport(itemset));
        }
    }
}
