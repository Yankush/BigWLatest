//package com.auto.bigw.page.def;
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.HttpResponse;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//
//public class UserPage {
//
//
//    public HttpResponse response;
//
//    public HttpResponse sendPostRequest()throws  Exception{
//
//        HttpClient client =  HttpClientBuilder.create().build();
//        HttpPost request = new HttpPost("https://reqres.in/api/users");
//
//            StringEntity params = new StringEntity(jSONContent());
//            params.setContentType("application/json");
//            request.addHeader("content-type", "application/json");
//            request.setEntity(params);
//            HttpResponse response = client.execute(request);
//            //String jsonResponse = convertResponseIntoString(response);
//            return response;
//    }
//
//    public void validateResponse()throws Exception{
//        String jsonResponse = convertResponseIntoString(response);
//        JSONObject jsonObject = new JSONObject(jsonResponse);
//        JSONArray data = jsonObject.getJSONArray("name");
//        //String stateCode = data.getJSONObject(0).getString("state_code");
//        //System.out.println("Get State Code ::" + stateCode);
//
//    }
//    public String convertResponseIntoString(HttpResponse response) throws Exception {
//
//        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//        StringBuffer result = new StringBuffer();
//        String line = "";
//
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//            System.out.println("result of API :: " + result);
//        }
//        return result.toString();
//    }
//
//    public  String jSONContent()throws Exception{
//
//        File file = new File(System.getProperty("user.dir") + "/src/SampleRestAssured/resources/payload/Sample.json");
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//            String everything = sb.toString();
//            System.out.println(everything);
//            return everything;
//        } finally {
//            br.close();
//        }
//    }
//
//
//
////    public static void main(String[] args) throws Exception{
////        UserPage up = new UserPage();
////        String text = up.UserPage();
////
////    }
//}
