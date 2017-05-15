/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserjava;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author mes
 */
public class CSVWriter {

    public void writeAsCSV(List<List<Map<String, String>>> all, String fileName) throws FileNotFoundException, IOException {
        boolean onfirstline = true;
        String output = "";
        Set<String> headers = null;
        SortedSet<String> custom_headers = new TreeSet<>();
        custom_headers.add("user_name");
        custom_headers.add("user_id");
        custom_headers.add("location_latitude");
        custom_headers.add("location_longitude");
        custom_headers.add("date");
        custom_headers.add("text"); 
        for (List<Map<String, String>> al : all) {
            if (onfirstline) {
                output = StringUtils.join(custom_headers.toArray(), ",")+","+"Stadium" + ","+"Game stage" + ","+"Game ID" + "\n";

                onfirstline = false;
            }
            for (Map<String, String> map : al) {
                if (!getCommaSeperatedRow(custom_headers, map).equals("")) {
                    output = output + getCommaSeperatedRow(custom_headers, map) + "\n";
                }
            }

            writeToFile(output, fileName);
        }
    }

    private String getCommaSeperatedRow(Set<String> headers, Map<String, String> map) {
        List<String> items = new ArrayList<String>();
        String retvalue = null;
        String value = null;
        outerloop:
        for (String header : headers) {
            if (header.equals("location_longitude") || header.equals("location_longitude")) {
                float val = Float.parseFloat(map.get(header));
                if (val == 0) {
                    retvalue = "";
                    items.clear();
                    break outerloop;
                } else {
                    value = map.get(header) == null ? "" : map.get(header).replace(",", "");
                    items.add(value);
                }
            } else {
                value = map.get(header) == null ? "" : map.get(header).replace(",", "");
                items.add(value);
            }
        }
        retvalue = StringUtils.join(items.toArray(), ",");
        return retvalue;
    }

    private void writeToFile(String output, String fileName) throws FileNotFoundException, IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(writer);
        }
    }

    private void close(BufferedWriter writer) {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Set<String> collectHeaders(List<Map<String, String>> flatJson) {
        Set<String> headers = new TreeSet<String>();
        for (Map<String, String> map : flatJson) {
            headers.addAll(map.keySet());
        }
        return headers;
    }
}
