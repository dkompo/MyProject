import java.io.File;

import generatedCode.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Created by dkomp on 28/4/2016.
 */
public class JAXBParser {


    public static void main(String[] args) {

        try {
            File file = new File("C:\\test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Employee emp = (Employee)unmarshaller.unmarshal(file);
            Person per = new Person();
            per.setAddress("Maikina 13");
            per.setAge("28");
            per.setName("Dkompo");
            System.out.println(per);
            System.out.println(emp);
            System.out.println("Added a new feature");
            System.out.println("Added a sec feature");
            System.out.println("Added a third feature!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
