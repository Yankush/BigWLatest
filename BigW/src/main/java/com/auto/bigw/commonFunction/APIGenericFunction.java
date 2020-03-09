package com.auto.bigw.commonFunction;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class APIGenericFunction {

    //READING CONTENT FROM PAYLOAD FOLDER
    public  String jSONContent(String jsonFileName)throws Exception{

        File file = new File(System.getProperty("user.dir") + "/src/SampleRestAssured/resources/payload/"+jsonFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
            return everything;
        } finally {
            br.close();
        }
    }

    public String convertResponseIntoString(HttpResponse response) throws Exception {

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";

        while ((line = rd.readLine()) != null) {
            result.append(line);
            System.out.println("result of API :: " + result);
        }
        return result.toString();
    }
}
