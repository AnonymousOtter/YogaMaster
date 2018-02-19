package algorithm;

import entity.Sensor;
import entity.TimeObject;
import entity.Wrist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SymmetryAnalyser {


    public static HashMap<String, String> analyseSymmetry(File file, String outputPath) throws IOException {

        Scanner inputStream = new Scanner(file);

        // GENERAL FIELDS

        ArrayList<Sensor> lw = new ArrayList<Sensor>();
        ArrayList<Sensor> rw = new ArrayList<Sensor>();

        ArrayList<TimeObject> all = new ArrayList<TimeObject>();

        int leftAccAdd = 0;
        int leftGyrAdd = 0;
        int leftMagAdd = 0;
        int rightAccAdd = 0;
        int rightGyrAdd = 0;
        int rightMagAdd = 0;

        String time = "";

        int j = 0;

        // DATA COLLATION LOOP
        while (inputStream.hasNext()) {

            String line = inputStream.nextLine();
            String[] values = line.split(",");
            if (j == 0) {
                time = values[0];
                j++;
            }

            // Creates ArrayLists
            if (time.contains(values[0].substring(0, 21))) {

                // Left Acc Sensor Object
                if (values[7].equals(" LW") && values[2].equals(" 0")) {

                    if (leftAccAdd == 0) {
                        Sensor acc = new Sensor(values[0], Integer.parseInt(values[2].substring(1)),
                                (-1 * Double.parseDouble(values[3])), Double.parseDouble(values[4]),
                                Double.parseDouble(values[5]), Double.parseDouble(values[6]), values[7]);

                        lw.add(acc);
                        leftAccAdd++;

                    }
                    if (leftAccAdd > 0) {

                        for (int c = lw.size() - 1; c >= 0; c--) {

                            Sensor s = lw.get(c);

                            if ((s.getLR().equals(" LW")) && (s.getType() == 0)) {

                                double setX = ((lw.get(c).getX() + (-1 * Double.parseDouble(values[3]))) / 2);
                                double setY = ((lw.get(c).getY() + Double.parseDouble(values[4])) / 2);
                                double setZ = ((lw.get(c).getZ() + Double.parseDouble(values[5])) / 2);

                                Sensor acc = new Sensor(values[0], Integer.parseInt(values[2].substring(1)), setX,
                                        setY, setZ, Double.parseDouble(values[6]), values[7]);

                                lw.remove(c);

                                lw.add(acc);
                                break;
                            }
                        }
                    }
                }

                // Left Gyr Sensor Object
                else if (values[7].equals(" LW") && values[2].equals(" 1")) {

                    if (leftGyrAdd == 0) {
                        Sensor gyr = new Sensor(values[0], Integer.parseInt(values[2].substring(1)),
                                Double.parseDouble(values[3]), Double.parseDouble(values[4]),
                                (-1 * Double.parseDouble(values[5])), Double.parseDouble(values[6]), values[7]);

                        lw.add(gyr);
                        leftGyrAdd++;

                    }
                    if (leftGyrAdd > 0) {

                        for (int c = lw.size() - 1; c >= 0; c--) {

                            Sensor s = lw.get(c);

                            if ((s.getLR().equals(" LW")) && (s.getType() == 1)) {

                                double setX = ((lw.get(c).getX() + Double.parseDouble(values[3])) / 2);
                                double setY = ((lw.get(c).getY() + Double.parseDouble(values[4])) / 2);
                                double setZ = ((lw.get(c).getZ() + (-1 * Double.parseDouble(values[5]))) / 2);

                                Sensor gyr = new Sensor(values[0], Integer.parseInt(values[2].substring(1)), setX,
                                        setY, setZ, Double.parseDouble(values[6]), values[7]);

                                lw.remove(c);

                                lw.add(gyr);
                                break;
                            }
                        }
                    }
                }

                // Left Mag Sensor Object
                else if (values[7].equals(" LW") && values[2].equals(" 2")) {

                    if (leftMagAdd == 0) {
                        Sensor mag = new Sensor(values[0], Integer.parseInt(values[2].substring(1)),
                                Double.parseDouble(values[3]), Double.parseDouble(values[4]),
                                Double.parseDouble(values[5]), Double.parseDouble(values[6]), values[7]);

                        lw.add(mag);
                        leftMagAdd++;

                    }
                    if (leftMagAdd > 0) {

                        for (int c = lw.size() - 1; c >= 0; c--) {

                            Sensor s = lw.get(c);

                            if ((s.getLR().equals(" LW")) && (s.getType() == 2)) {

                                double setX = ((lw.get(c).getX() + Double.parseDouble(values[3])) / 2);
                                double setY = ((lw.get(c).getY() + Double.parseDouble(values[4])) / 2);
                                double setZ = ((lw.get(c).getZ() + Double.parseDouble(values[5])) / 2);

                                Sensor mag = new Sensor(values[0], Integer.parseInt(values[2].substring(1)), setX,
                                        setY, setZ, Double.parseDouble(values[6]), values[7]);

                                lw.remove(c);

                                lw.add(mag);
                                break;
                            }
                        }
                    }
                }

                // Right Acc Sensor Object
                if (values[7].equals(" RW") && values[2].equals(" 0")) {

                    if (rightAccAdd == 0) {
                        Sensor acc = new Sensor(values[0], Integer.parseInt(values[2].substring(1)),
                                Double.parseDouble(values[3]), Double.parseDouble(values[4]),
                                Double.parseDouble(values[5]), Double.parseDouble(values[6]), values[7]);

                        rw.add(acc);
                        rightAccAdd++;

                    }
                    if (rightAccAdd > 0) {

                        for (int c = rw.size() - 1; c >= 0; c--) {

                            Sensor s = rw.get(c);

                            if ((s.getLR().equals(" RW")) && (s.getType() == 0)) {

                                double setX = ((rw.get(c).getX() + Double.parseDouble(values[3])) / 2);
                                double setY = ((rw.get(c).getY() + Double.parseDouble(values[4])) / 2);
                                double setZ = ((rw.get(c).getZ() + Double.parseDouble(values[5])) / 2);

                                Sensor acc = new Sensor(values[0], Integer.parseInt(values[2].substring(1)), setX,
                                        setY, setZ, Double.parseDouble(values[6]), values[7]);

                                rw.remove(c);

                                rw.add(acc);
                                break;
                            }
                        }
                    }
                }

                // Right Gyr Sensor Object
                else if (values[7].equals(" RW") && values[2].equals(" 1")) {

                    if (rightGyrAdd == 0) {
                        Sensor gyr = new Sensor(values[0], Integer.parseInt(values[2].substring(1)),
                                Double.parseDouble(values[3]), Double.parseDouble(values[4]),
                                Double.parseDouble(values[5]), Double.parseDouble(values[6]), values[7]);

                        rw.add(gyr);
                        rightGyrAdd++;

                    }
                    if (rightGyrAdd > 0) {

                        for (int c = rw.size() - 1; c >= 0; c--) {

                            Sensor s = rw.get(c);

                            if ((s.getLR().equals(" RW")) && (s.getType() == 1)) {

                                double setX = ((rw.get(c).getX() + Double.parseDouble(values[3])) / 2);
                                double setY = ((rw.get(c).getY() + Double.parseDouble(values[4])) / 2);
                                double setZ = ((rw.get(c).getZ() + Double.parseDouble(values[5])) / 2);

                                Sensor gyr = new Sensor(values[0], Integer.parseInt(values[2].substring(1)), setX,
                                        setY, setZ, Double.parseDouble(values[6]), values[7]);

                                rw.remove(c);

                                rw.add(gyr);
                                break;
                            }
                        }
                    }
                }

                // Right Mag Sensor Object
                else if (values[7].equals(" RW") && values[2].equals(" 2")) {

                    if (rightMagAdd == 0) {
                        Sensor mag = new Sensor(values[0], Integer.parseInt(values[2].substring(1)),
                                Double.parseDouble(values[3]), Double.parseDouble(values[4]),
                                Double.parseDouble(values[5]), Double.parseDouble(values[6]), values[7]);

                        rw.add(mag);
                        rightMagAdd++;

                    }
                    if (rightMagAdd > 0) {

                        for (int c = rw.size() - 1; c >= 0; c--) {

                            Sensor s = rw.get(c);

                            if ((s.getLR().equals(" RW")) && (s.getType() == 2)) {

                                double setX = ((rw.get(c).getX() + Double.parseDouble(values[3])) / 2);
                                double setY = ((rw.get(c).getY() + Double.parseDouble(values[4])) / 2);
                                double setZ = ((rw.get(c).getZ() + Double.parseDouble(values[5])) / 2);

                                Sensor mag = new Sensor(values[0], Integer.parseInt(values[2].substring(1)), setX,
                                        setY, setZ, Double.parseDouble(values[6]), values[7]);

                                rw.remove(c);

                                rw.add(mag);
                                break;
                            }
                        }
                    }
                }
            } else {

                Sensor accelL = new Sensor();
                Sensor magnoL = new Sensor();
                Sensor gyroL = new Sensor();

                Sensor accelR = new Sensor();
                Sensor magnoR = new Sensor();
                Sensor gyroR = new Sensor();

                for (Sensor t : lw) {
                    if (t.getType() == 0) {
                        accelL = t;
                    } else if (t.getType() == 1) {
                        gyroL = t;
                    } else if (t.getType() == 2) {
                        magnoL = t;
                    }
                }

                for (Sensor t : rw) {
                    if (t.getType() == 0) {
                        accelR = t;
                    } else if (t.getType() == 1) {
                        gyroR = t;
                    } else if (t.getType() == 2) {
                        magnoR = t;
                    }
                }

                Wrist left = new Wrist("left", accelL, gyroL, magnoL);
                Wrist right = new Wrist("right", accelR, gyroR, magnoR);

                TimeObject timeObject = new TimeObject(time, right, left);
                all.add(timeObject);

                time = values[0];
                j = 0;
            }
        }

        // -------------------------------------------------------------------------------------------------------------------------
        // JSON CREATOR FIELDS

        JSONObject chartInfo = new JSONObject();
        JSONObject everything = new JSONObject();
        JSONObject category = new JSONObject();

        JSONObject dataLAX = new JSONObject();
        JSONObject dataLAY = new JSONObject();
        JSONObject dataLAZ = new JSONObject();
        JSONObject dataLGX = new JSONObject();
        JSONObject dataLGY = new JSONObject();
        JSONObject dataLGZ = new JSONObject();
        JSONObject dataLMX = new JSONObject();
        JSONObject dataLMY = new JSONObject();
        JSONObject dataLMZ = new JSONObject();

        JSONObject dataRAX = new JSONObject();
        JSONObject dataRAY = new JSONObject();
        JSONObject dataRAZ = new JSONObject();
        JSONObject dataRGX = new JSONObject();
        JSONObject dataRGY = new JSONObject();
        JSONObject dataRGZ = new JSONObject();
        JSONObject dataRMX = new JSONObject();
        JSONObject dataRMY = new JSONObject();
        JSONObject dataRMZ = new JSONObject();

        JSONArray categories = new JSONArray();
        JSONArray dataset = new JSONArray();

        JSONObject everythingError = new JSONObject();
        JSONArray datasetError = new JSONArray();

        JSONObject lavXOb = new JSONObject();
        JSONObject lgvXOb = new JSONObject();
        JSONObject lmvXOb = new JSONObject();
        JSONObject lavYOb = new JSONObject();
        JSONObject lgvYOb = new JSONObject();
        JSONObject lmvYOb = new JSONObject();
        JSONObject lavZOb = new JSONObject();
        JSONObject lgvZOb = new JSONObject();
        JSONObject lmvZOb = new JSONObject();

        JSONObject ravXOb = new JSONObject();
        JSONObject rgvXOb = new JSONObject();
        JSONObject rmvXOb = new JSONObject();
        JSONObject ravYOb = new JSONObject();
        JSONObject rgvYOb = new JSONObject();
        JSONObject rmvYOb = new JSONObject();
        JSONObject ravZOb = new JSONObject();
        JSONObject rgvZOb = new JSONObject();
        JSONObject rmvZOb = new JSONObject();

        String lavXSt = "";
        String lgvXSt = "";
        String lmvXSt = "";
        String lavYSt = "";
        String lgvYSt = "";
        String lmvYSt = "";
        String lavZSt = "";
        String lgvZSt = "";
        String lmvZSt = "";

        String ravXSt = "";
        String rgvXSt = "";
        String rmvXSt = "";
        String ravYSt = "";
        String rgvYSt = "";
        String rmvYSt = "";
        String ravZSt = "";
        String rgvZSt = "";
        String rmvZSt = "";

        // -------------------------------------------------------------------------------------------------------------------------
        // ACC JSON CREATOR

        for (TimeObject t : all) {

            double accelLX = t.getLeft().getAccel().getX();
            double accelLY = t.getLeft().getAccel().getY();
            double accelLZ = t.getRight().getAccel().getZ();
            double gyroLX = t.getLeft().getGyro().getX();
            double gyroLY = t.getLeft().getGyro().getY();
            double gyroLZ = t.getLeft().getGyro().getZ();
            double magnoLX = t.getLeft().getMagno().getX();
            double magnoLY = t.getLeft().getMagno().getY();
            double magnoLZ = t.getLeft().getMagno().getZ();

            double accelRX = t.getRight().getAccel().getX();
            double accelRY = t.getRight().getAccel().getY();
            double accelRZ = t.getRight().getAccel().getZ();
            double gyroRX = t.getRight().getGyro().getX();
            double gyroRY = t.getRight().getGyro().getY();
            double gyroRZ = t.getRight().getGyro().getZ();
            double magnoRX = t.getRight().getMagno().getX();
            double magnoRY = t.getRight().getMagno().getY();
            double magnoRZ = t.getRight().getMagno().getZ();

            lavXSt = lavXSt + accelLX + "|";
            lavYSt = lavYSt + accelLY + "|";
            lavZSt = lavZSt + accelLZ + "|";
            lgvXSt = lgvXSt + gyroLX + "|";
            lgvYSt = lgvYSt + gyroLY + "|";
            lgvZSt = lgvZSt + gyroLZ + "|";
            lmvXSt = lmvXSt + magnoLX + "|";
            lmvYSt = lmvYSt + magnoLY + "|";
            lmvZSt = lmvZSt + magnoLZ + "|";

            ravXSt = ravXSt + accelRX + "|";
            ravYSt = ravYSt + accelRY + "|";
            ravZSt = ravZSt + accelRZ + "|";
            rgvXSt = rgvXSt + gyroRX + "|";
            rgvYSt = rgvYSt + gyroRY + "|";
            rgvZSt = rgvZSt + gyroRZ + "|";
            rmvXSt = rmvXSt + magnoRX + "|";
            rmvYSt = rmvYSt + magnoRY + "|";
            rmvZSt = rmvZSt + magnoRZ + "|";

        }

        dataLAX.put("seriesName", "Left Acceleromter X");
        dataLAY.put("seriesName", "Left Acceleromter Y");
        dataLAZ.put("seriesName", "Left Acceleromter Z");
        dataLGX.put("seriesName", "Left Gyroscope X");
        dataLGY.put("seriesName", "Left Gyroscope Y");
        dataLGZ.put("seriesName", "Left Gyroscope Z");
        dataLMX.put("seriesName", "Left Magnetometer X");
        dataLMY.put("seriesName", "Left Magnetometer Y");
        dataLMZ.put("seriesName", "Left Magnetometer Z");

        dataRAX.put("seriesName", "Right Accelerometer X");
        dataRAY.put("seriesName", "Right Accelerometer Y");
        dataRAZ.put("seriesName", "Right Accelerometer Z");
        dataRGX.put("seriesName", "Right Gyroscope X");
        dataRGY.put("seriesName", "Right Gyroscope Y");
        dataRGZ.put("seriesName", "Right Gyroscope Z");
        dataRMX.put("seriesName", "Right Magnetometer X");
        dataRMY.put("seriesName", "Right Magnetometer Y");
        dataRMZ.put("seriesName", "Right Magnetometer Z");

        dataLAX.put("data", lavXSt);
        dataLAY.put("data", lavYSt);
        dataLAZ.put("data", lavZSt);
        dataLGX.put("data", lgvXSt);
        dataLGY.put("data", lgvYSt);
        dataLGZ.put("data", lgvZSt);
        dataLMX.put("data", lmvXSt);
        dataLMY.put("data", lmvYSt);
        dataLMZ.put("data", lmvZSt);

        dataRAX.put("data", ravXSt);
        dataRAY.put("data", ravYSt);
        dataRAZ.put("data", ravZSt);
        dataRGX.put("data", rgvXSt);
        dataRGY.put("data", rgvYSt);
        dataRGZ.put("data", rgvZSt);
        dataRMX.put("data", rmvXSt);
        dataRMY.put("data", rmvYSt);
        dataRMZ.put("data", rmvZSt);

        String allTime = "";

        for (TimeObject t : all) {
            System.out.println(t.getTime());
            allTime = allTime + t.getTime().substring(11, 20) + "|";

        }

        allTime = allTime.substring(0, allTime.length() - 1);

        String caption = "Values of Accelerometer";
        String subcaption = "Split by Left and Right Wrist";
        String showHoverEffect = "1";
        String theme = "hulk-light";
        String yaxisname = "Value";
        String xaxisname = "Time";
        String forceAxisLimits = "1";
        String pixelsPerPoint = "0";
        String lineThickness = "1";
        String compactdatamode = "1";
        String dataseparator = "|";
        String scrollheight = "9";
        String flatScrollBars = "1";
        String scrollShowButtons = "1";
        String drawCustomLegendIcon = "1";
        String showAlternateHGridColor = "0";

        chartInfo.put("caption", caption);
        chartInfo.put("subcaption", subcaption);
        chartInfo.put("showHoverEffect", showHoverEffect);
        chartInfo.put("theme", theme);
        chartInfo.put("yaxisname", yaxisname);
        chartInfo.put("xaxisname", xaxisname);
        chartInfo.put("forceAxisLimits", forceAxisLimits);
        chartInfo.put("pixelsPerPoint", pixelsPerPoint);
        chartInfo.put("lineThickness", lineThickness);
        chartInfo.put("compactdatamode", compactdatamode);
        chartInfo.put("dataseparator", dataseparator);
        chartInfo.put("scrollheight", scrollheight);
        chartInfo.put("flatScrollBars", flatScrollBars);
        chartInfo.put("scrollShowButtons", scrollShowButtons);
        chartInfo.put("drawCustomLegendIcon", drawCustomLegendIcon);
        chartInfo.put("showAlternateHGridColor", showAlternateHGridColor);

        dataset.add(dataLAX);
        dataset.add(dataLAY);
        dataset.add(dataLAZ);
        dataset.add(dataLGX);
        dataset.add(dataLGY);
        dataset.add(dataLGZ);

        dataset.add(dataLAX);
        dataset.add(dataRAY);
        dataset.add(dataRAZ);
        dataset.add(dataRGX);
        dataset.add(dataRGY);
        dataset.add(dataRGZ);

        category.put("category", allTime);
        categories.add(category);

        everything.put("chart", chartInfo);
        everything.put("categories", categories);

        everything.put("dataset", dataset);


        HashMap<String, String> dataToProcess = new HashMap<String, String>();

        try (FileWriter jsonfile = new FileWriter(outputPath + "/json.txt")) {

            jsonfile.write(everything.toJSONString());

            String symmetry = new String (outputPath + "/json.txt");

            dataToProcess.put("symmetry", symmetry);

            System.out.println();
            System.out.println("Successfully Copied JSON Object to File...");
        }

        // -------------------------------------------------------------------------------------------------------------------------
        // ERROR JSON CREATOR

        lavXSt = "";
        lgvXSt = "";
        lmvXSt = "";
        lavYSt = "";
        lgvYSt = "";
        lmvYSt = "";
        lavZSt = "";
        lgvZSt = "";
        lmvZSt = "";

        ravXSt = "";
        rgvXSt = "";
        rmvXSt = "";
        ravYSt = "";
        rgvYSt = "";
        rmvYSt = "";
        ravZSt = "";
        rgvZSt = "";
        rmvZSt = "";

        for (TimeObject t : all) {

            int lat = t.getLeft().getAccel().getType();
            int lgt = t.getLeft().getGyro().getType();
            int lmt = t.getLeft().getMagno().getType();
            int rat = t.getRight().getAccel().getType();
            int rgt = t.getRight().getGyro().getType();
            int rmt = t.getRight().getMagno().getType();

            lavXSt = lavXSt + t.avX(lat) + "|";
            lavYSt = lavYSt + t.avY(lat) + "|";
            lavZSt = lavZSt + t.avZ(lat) + "|";

            lgvXSt = lgvXSt + t.avX(lgt) + "|";
            lgvYSt = lgvYSt + t.avY(lgt) + "|";
            lgvZSt = lgvZSt + t.avZ(lgt) + "|";

            lmvXSt = lmvXSt + t.avX(lmt) + "|";
            lmvYSt = lmvYSt + t.avY(lmt) + "|";
            lmvZSt = lmvZSt + t.avZ(lmt) + "|";

            ravXSt = ravXSt + t.avX(rat) + "|";
            ravYSt = ravYSt + t.avY(rat) + "|";
            ravZSt = ravZSt + t.avZ(rat) + "|";

            rgvXSt = rgvXSt + t.avX(rgt) + "|";
            rgvYSt = rgvYSt + t.avY(rgt) + "|";
            rgvZSt = rgvZSt + t.avZ(rgt) + "|";

            rmvXSt = rmvXSt + t.avX(rmt) + "|";
            rmvYSt = rmvYSt + t.avY(rmt) + "|";
            rmvZSt = rmvZSt + t.avZ(rmt) + "|";

        }

        lavXSt = lavXSt.substring(0, lavXSt.length() - 1);
        lgvXSt = lgvXSt.substring(0, lgvXSt.length() - 1);
        lmvXSt = lmvXSt.substring(0, lmvXSt.length() - 1);
        lavYSt = lavYSt.substring(0, lavYSt.length() - 1);
        lgvYSt = lgvYSt.substring(0, lgvYSt.length() - 1);
        lmvYSt = lmvYSt.substring(0, lmvYSt.length() - 1);
        lavZSt = lavZSt.substring(0, lavZSt.length() - 1);
        lgvZSt = lgvZSt.substring(0, lgvZSt.length() - 1);
        lmvZSt = lmvZSt.substring(0, lmvZSt.length() - 1);
        ravXSt = ravXSt.substring(0, ravXSt.length() - 1);
        rgvXSt = rgvXSt.substring(0, rgvXSt.length() - 1);
        rmvXSt = rmvXSt.substring(0, rmvXSt.length() - 1);
        ravYSt = ravYSt.substring(0, ravYSt.length() - 1);
        rgvYSt = rgvYSt.substring(0, rgvYSt.length() - 1);
        rmvYSt = rmvYSt.substring(0, rmvYSt.length() - 1);
        ravZSt = ravZSt.substring(0, ravZSt.length() - 1);
        rgvZSt = rgvZSt.substring(0, rgvZSt.length() - 1);
        rmvZSt = rmvZSt.substring(0, rmvZSt.length() - 1);

        lavXOb.put("seriesName", "Left Accel X");
        lavXOb.put("anchorBgColor", "#876EA1");
        lavXOb.put("data", lavXSt);

        lgvXOb.put("seriesName", "Left Gyro X");
        lgvXOb.put("anchorBgColor", "#3f7cff");
        lgvXOb.put("data", lgvXSt);

        lmvXOb.put("seriesName", "Left Magno X");
        lmvXOb.put("anchorBgColor", "#52eeff");
        lmvXOb.put("data", lmvXSt);

        lavYOb.put("seriesName", "Left Accel Y");
        lavYOb.put("anchorBgColor", "#5aff86");
        lavYOb.put("data", lavYSt);

        lgvYOb.put("seriesName", "Left Gyro Y");
        lgvYOb.put("anchorBgColor", "#33c901");
        lgvYOb.put("data", lgvYSt);

        lmvYOb.put("seriesName", "Left Magno Y");
        lmvYOb.put("anchorBgColor", "#e5e848");
        lmvYOb.put("data", lmvYSt);

        lavZOb.put("seriesName", "Left Accel Z");
        lavZOb.put("anchorBgColor", "#ffbb00");
        lavZOb.put("data", lavZSt);

        lgvZOb.put("seriesName", "Left Gyro Z");
        lgvZOb.put("anchorBgColor", "#ff6f00");
        lgvZOb.put("data", lgvZSt);

        lmvZOb.put("seriesName", "Left Magno Z");
        lmvZOb.put("anchorBgColor", "#ff4400");
        lmvZOb.put("data", lmvZSt);

        ravXOb.put("seriesName", "Right Accel X");
        ravXOb.put("anchorBgColor", "#ffb488");
        ravXOb.put("data", ravXSt);

        rgvXOb.put("seriesName", "Right Gyro X");
        rgvXOb.put("anchorBgColor", "#ff7775");
        rgvXOb.put("data", rgvXSt);

        rmvXOb.put("seriesName", "Right Magno X");
        rmvXOb.put("anchorBgColor", "#ff609a");
        rmvXOb.put("data", rmvXSt);

        ravYOb.put("seriesName", "Right Accel Y");
        ravYOb.put("anchorBgColor", "#ff84e4");
        ravYOb.put("data", ravYSt);

        rgvYOb.put("seriesName", "Right Gyro Y");
        rgvYOb.put("anchorBgColor", "#dd45ff");
        rgvYOb.put("data", rgvYSt);

        rmvYOb.put("seriesName", "Right Magno Y");
        rmvYOb.put("anchorBgColor", "#ab92ff");
        rmvYOb.put("data", rmvYSt);

        ravZOb.put("seriesName", "Right Accel Z");
        ravZOb.put("anchorBgColor", "#a530ff");
        ravZOb.put("data", ravZSt);

        rgvZOb.put("seriesName", "Right Gyro Z");
        rgvZOb.put("anchorBgColor", "#bfffbd");
        rgvZOb.put("data", rgvZSt);

        rmvZOb.put("seriesName", "Right Magno Z");
        rmvZOb.put("anchorBgColor", "#4a4466");
        rmvZOb.put("data", rmvZSt);

        datasetError.add(lavXOb);
        datasetError.add(lgvXOb);
        datasetError.add(lmvXOb);
        datasetError.add(lavYOb);
        datasetError.add(lgvYOb);
        datasetError.add(lmvYOb);
        datasetError.add(lavZOb);
        datasetError.add(lgvZOb);
        datasetError.add(lmvZOb);
        datasetError.add(ravXOb);
        datasetError.add(rgvXOb);
        datasetError.add(rmvXOb);
        datasetError.add(ravYOb);
        datasetError.add(rgvYOb);
        datasetError.add(rmvYOb);
        datasetError.add(ravZOb);
        datasetError.add(rgvZOb);
        datasetError.add(rmvZOb);

        String allTimeE = "";

        for (TimeObject t : all) {
            allTimeE = allTimeE + t.getTime().substring(12, 20) + "|";
        }

        allTimeE = allTimeE.substring(0, allTimeE.length() - 1);

        chartInfo.clear();

        caption = "Error Values";
        subcaption = "Divided by Limb, Sensor and Axis";

        chartInfo.put("caption", caption);
        chartInfo.put("subcaption", subcaption);
        chartInfo.put("showHoverEffect", showHoverEffect);
        chartInfo.put("theme", theme);
        chartInfo.put("yaxisname", yaxisname);
        chartInfo.put("xaxisname", xaxisname);
        chartInfo.put("forceAxisLimits", forceAxisLimits);
        chartInfo.put("pixelsPerPoint", pixelsPerPoint);
        chartInfo.put("lineThickness", lineThickness);
        chartInfo.put("compactdatamode", compactdatamode);
        chartInfo.put("dataseparator", dataseparator);
        chartInfo.put("scrollheight", scrollheight);
        chartInfo.put("flatScrollBars", flatScrollBars);
        chartInfo.put("scrollShowButtons", scrollShowButtons);
        chartInfo.put("drawCustomLegendIcon", drawCustomLegendIcon);
        chartInfo.put("showAlternateHGridColor", showAlternateHGridColor);

        category.put("category", allTimeE);
        categories.add(category);

        everythingError.put("chart", chartInfo);
        everythingError.put("categories", categories);

        everythingError.put("dataset", datasetError);

        try (FileWriter jsonErrorfile = new FileWriter( outputPath + "/jsonError.txt")) {

            jsonErrorfile.write(everythingError.toJSONString());

            String error = new String (outputPath +  "/jsonError.txt");
            System.out.println(error);
            dataToProcess.put("error", error);

            System.out.println();
            System.out.println("Successfully Copied JSON Object to File...");
        }

        inputStream.close();

        System.out.println("DONE");

        return dataToProcess;

    }
}
