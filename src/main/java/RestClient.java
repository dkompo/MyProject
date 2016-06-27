import dim.model.CityInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by dkomp on 20/6/2016.
 */
public class RestClient {

    private final static String APIKEY = "b0289f960dd90a58cab00b69c168c922";

    public static void main(String[] args) {


        try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Athens&APPID=" + APIKEY);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("squid.eurodyn.com", 8080));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            // Read json from http get
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String jsdata = "";
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                jsdata = output + jsdata;
                // System.out.println(output);
            }

            //Create parser in order to parse json String
            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createJsonParser(jsdata);
//            JSONObject json = new JSONObject(jsdata);
//            System.out.println(json);
            conn.disconnect();
            CityInfo cityInfo = null;
            TestModel testModel = new TestModel();
            ObjectMapper mapper = new ObjectMapper();

            cityInfo = mapper.readValue(parser, CityInfo.class);
            BeanUtils.copyProperties(testModel, cityInfo);
            System.out.println(cityInfo);
            System.out.println("\n \n \n"+ testModel);
            double currentTempInCelsius;
            double kelvinTemp = Double.parseDouble(cityInfo.getMain().getTemp());
            currentTempInCelsius = kelvinTemp - 273;
            System.out.println("Current temperature in "+ cityInfo.getName() + " is " + currentTempInCelsius);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
