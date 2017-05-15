/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemsetCreator;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mes
 */
public class TimeStamping {

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    Date d1 = null;
    Date d2 = null;

    String t15 = "15:00:00";
    String t17 = "17:00:00";
    String t18 = "18:00:00";
    String t19 = "19:00:00";
    String t20 = "20:00:00";
    String t21 = "21:00:00";
    String gamefrst = null;
    String gamesecond = null;
//    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

    public String timuka(String line, String VenueName, String Directoryname) throws ParseException, IOException {
//        System.out.println("=====================param values we accept are venue :=" + VenueName + "///directry name=" + Directoryname + "////line=" + line);
        if (VenueName.equals("FR3") && Directoryname.equals("2016-08-03.Group")) {
            d1 = format.parse(t21);
            gamefrst = "G5";
            gamesecond = "G6";
        }
        if (VenueName.equals("FR4") && Directoryname.equals("2016-08-03.Group")) {
            d1 = format.parse(t17);
            gamefrst = "G2";
            gamesecond = "G4";
        }
        if (VenueName.equals("M1") && Directoryname.equals("2016-08-03.Group")) {
            d1 = format.parse(t15);
            gamefrst = "G1";
            gamesecond = "G3";
        }
        if (VenueName.equals("FR1") && Directoryname.equals("2016-08-04.Group")) {
            d1 = format.parse(t19);
            gamefrst = "M7";
            gamesecond = "M4";
        }
        if (VenueName.equals("FR2") && Directoryname.equals("2016-08-04.Group")) {
            d1 = format.parse(t15);
            gamefrst = "M1";
            gamesecond = "M3";
        }
        if (VenueName.equals("FR5") && Directoryname.equals("2016-08-04.Group")) {
            d1 = format.parse(t20);
            gamefrst = "M6";
            gamesecond = "M8";
        }
        if (VenueName.equals("M1") && Directoryname.equals("2016-08-04.Group")) {
            d1 = format.parse(t17);
            gamefrst = "M2";
            gamesecond = "M5";
        }
        if (VenueName.equals("FR3") && Directoryname.equals("2016-08-06.Group")) {
            d1 = format.parse(t19);
            gamefrst = "G8";
            gamesecond = "G11";
        }
        if (VenueName.equals("FR4") && Directoryname.equals("2016-08-06.Group")) {
            d1 = format.parse(t17);
            gamefrst = "G7";
            gamesecond = "G9";
        }
        if (VenueName.equals("M1") && Directoryname.equals("2016-08-06.Group")) {
            d1 = format.parse(t21);
            gamefrst = "G10";
            gamesecond = "G12";
        }
        if (VenueName.equals("FR1") && Directoryname.equals("2016-08-07.Group")) {
            d1 = format.parse(t15);
            gamefrst = "M12";
            gamesecond = "M15";
        }
        if (VenueName.equals("FR2") && Directoryname.equals("2016-08-07.Group")) {
            d1 = format.parse(t21);
            gamefrst = "M14";
            gamesecond = "M16";
        }
        if (VenueName.equals("FR5") && Directoryname.equals("2016-08-07.Group")) {
            d1 = format.parse(t20);
            gamefrst = "M9";
            gamesecond = "M11";
        }
        if (VenueName.equals("M1") && Directoryname.equals("2016-08-07.Group")) {
            d1 = format.parse(t17);
            gamefrst = "M10";
            gamesecond = "M13";
        }
        if (VenueName.equals("FR1") && Directoryname.equals("2016-08-09.Group")) {
            d1 = format.parse(t18);
            gamefrst = "G17";
            gamesecond = "G14";
        }
        if (VenueName.equals("FR2") && Directoryname.equals("2016-08-09.Group")) {
            d1 = format.parse(t19);
            gamefrst = "G18";
            gamesecond = "G16";
        }
        if (VenueName.equals("FR5") && Directoryname.equals("2016-08-09.Group")) {
            d1 = format.parse(t18);
            gamefrst = "G13";
            gamesecond = "G15";
        }//////////10
        if (VenueName.equals("FR1") && Directoryname.equals("2016-08-10.Group")) {
            d1 = format.parse(t21);
            gamefrst = "M22";
            gamesecond = "M23";
        }
        if (VenueName.equals("FR2") && Directoryname.equals("2016-08-10.Group")) {
            d1 = format.parse(t15);
            gamefrst = "M18";
            gamesecond = "M20";
        }
        if (VenueName.equals("FR3") && Directoryname.equals("2016-08-10.Group")) {
            d1 = format.parse(t15);
            gamefrst = "M17";
            gamesecond = "M19";
        }
        if (VenueName.equals("FR4") && Directoryname.equals("2016-08-10.Group")) {
            d1 = format.parse(t21);
            gamefrst = "M21";
            gamesecond = "M24";
        }
        //////////12
        if (VenueName.equals("FR1") && Directoryname.equals("2016-08-12.QuarterFinal")) {
            d1 = format.parse(t21);
            gamefrst = "G20";
            gamesecond = "G20";
        }
        if (VenueName.equals("FR2") && Directoryname.equals("2016-08-12.QuarterFinal")) {
            d1 = format.parse(t15);
            gamefrst = "G19";
            gamesecond = "G19";
        }
        if (VenueName.equals("FR3") && Directoryname.equals("2016-08-12.QuarterFinal")) {
            d1 = format.parse(t15);
            gamefrst = "G22";
            gamesecond = "G22";
        }
        if (VenueName.equals("FR4") && Directoryname.equals("2016-08-12.QuarterFinal")) {
            d1 = format.parse(t21);
            gamefrst = "G21";
            gamesecond = "G21";
        }
        //////////13
        if (VenueName.equals("FR1") && Directoryname.equals("2016-08-13.QuarterFinal")) {
            d1 = format.parse(t21);
            gamefrst = "M26";
            gamesecond = "M26";
        }
        if (VenueName.equals("FR2") && Directoryname.equals("2016-08-13.QuarterFinal")) {
            d1 = format.parse(t15);
            gamefrst = "M25";
            gamesecond = "M25";
        }
        if (VenueName.equals("FR3") && Directoryname.equals("2016-08-13.QuarterFinal")) {
            d1 = format.parse(t15);
            gamefrst = "M27";
            gamesecond = "M27";
        }
        if (VenueName.equals("FR4") && Directoryname.equals("2016-08-13.QuarterFinal")) {
            d1 = format.parse(t21);
            gamefrst = "M28";
            gamesecond = "M28";
        }

        //////////16
        if (VenueName.equals("FR3") && Directoryname.equals("2016-08-16.SemiFinal")) {
            d1 = format.parse(t21);
            gamefrst = "G23";
            gamesecond = "G23";
        }
        if (VenueName.equals("M3") && Directoryname.equals("2016-08-16.SemiFinal")) {
            d1 = format.parse(t15);
            gamefrst = "G24";
            gamesecond = "G24";
        }
        //////////17
        if (VenueName.equals("FR4") && Directoryname.equals("2016-08-17.SemiFinal")) {
            d1 = format.parse(t21);
            gamefrst = "M29";
            gamesecond = "M29";
        }
        if (VenueName.equals("M3") && Directoryname.equals("2016-08-17.SemiFinal")) {
            d1 = format.parse(t15);
            gamefrst = "M30";
            gamesecond = "M30";
        }

        //////////19
        if (VenueName.equals("FR4") && Directoryname.equals("2016-08-19.ThirdFourth")) {
            d1 = format.parse(t21);
            gamefrst = "G25";
            gamesecond = "G25";
        }
        if (VenueName.equals("M3") && Directoryname.equals("2016-08-19.ThirdFourth")) {
            d1 = format.parse(t15);
            gamefrst = "G26";
            gamesecond = "G26";
        }

        //////////20
        if (VenueName.equals("FR3") && Directoryname.equals("2016-08-20.ThirdFourth")) {
            d1 = format.parse(t21);
            gamefrst = "M31";
            gamesecond = "M31";
        }
        if (VenueName.equals("M3") && Directoryname.equals("2016-08-20.ThirdFourth")) {
            d1 = format.parse(t15);
            gamefrst = "M32";
            gamesecond = "M32";
        }
        String[] nextLine2 = line.split(",");

        String zdate = nextLine2[0];
        String[] actual = zdate.split("\\s+");
        d2 = format.parse(actual[3]);
        if (d2.before(d1) || d2.equals(d1)) {

            return gamefrst;
        } else {
            return gamesecond;
        }
    }

}
