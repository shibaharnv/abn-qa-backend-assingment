package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Random;


public class Utils {

    public static RequestSpecification req;


    /**
     * Returns the  request specification object that contains base url and oauthtoken
     * and enables login functionality

     * This method is used to capture the endpoint url and oauth token from global.properties
     * also using request logging filter logs the details in a file
     * @param  *none
     * @return      request specification object
     */

    public RequestSpecification requestSpecificationMethod() throws IOException {

        if(req==null) {

            PrintStream log = new PrintStream(new FileOutputStream("src/test/java/logs/logs.txt"));

            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addHeader("Authorization", "Bearer "+getGlobalValue("oauthtoken")+"")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return req;
        }
        return req;

    }



    /**
     * Returns the  property key value from the global properties file
     *

     * This method is used to capture the endpoint url and oauth token from global.properties
     * also using request logging filter logs the details in a file
     * @param  key
     * @return  value
     */

    public static String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();
        String path =System.getProperty("user.dir");
        String end="/src/test/resources/global.properties";
        String fullPath =path.concat(end);
        FileInputStream fis =new FileInputStream(fullPath);
        prop.load(fis);
        return prop.getProperty(key);

    }



    /**
     * Returns the json key value by taking the response and key as input
     * This method is used to find out the json key value
     * @param  response
     * @param  key
     * @return  json key value
     */
    public String getJsonPath(Response response,String key)
    {
        String resp=response.asString();
        JsonPath   js = new JsonPath(resp);
        return js.get(key).toString();
    }



    /**
     * Returns the  generated random string
     * This method is used to generate the random string
     * @param  none
     * @return  randomString
     */
    public static String randomStringGeneration() {
        Random robj = new Random();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        String newWord = "";
        for (int i = 0; i < 10; i++) {
            char c = alphabets.charAt(robj.nextInt(15));
            newWord = newWord + c;
        }
        return newWord;
    }

}
