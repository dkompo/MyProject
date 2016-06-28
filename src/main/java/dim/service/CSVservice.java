package dim.service;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by dkomp on 28/6/2016.
 */
public class CSVservice {


    final private String csvPath = "c:\\test.csv";


    public void generateCsvFile() {
        try {
//            FileWriter writer = new FileWriter(csvPath);
//
//            writer.append("DisplayName");
//            writer.append(',');
//            writer.append("Age");
//            writer.append('\n');
//
//            writer.append("MKYONG");
//            writer.append(',');
//            writer.append("26");
//            writer.append('\n');
//
//            writer.append("YOUR NAME");
//            writer.append(',');
//            writer.append("29");
//            writer.append('\n');
//
//            //generate whatever data you want
//
//            writer.flush();
//            writer.close();

//            FileInputStream fis = new FileInputStream(csvPath);
//            byte[] b = new byte[fis.available()];
//            outputStream.write(b);
//            outputStream.flush();
//            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateCSV() {
        String csvText = "";


        csvText+="DisplayName";
        csvText+= ",";
        csvText+= "Age";
        csvText+= "\n";

        csvText+= "Messi";
        csvText+= ",";
        csvText+= "29";
        csvText+= "\n";

        csvText+= "Dim";
        csvText+= ",";
        csvText+= "28";
        csvText+= "\n";
        return  csvText;
    }


}




