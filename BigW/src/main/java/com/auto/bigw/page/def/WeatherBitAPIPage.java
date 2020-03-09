//package com.auto.bigw.page.def;
//
//import com.auto.bigw.commonFunction.GenericFunction;
//import junit.framework.Assert;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class WeatherBitAPIPage {
//
//
//    public HttpResponse executeCurrentAPIGetRequest() throws Throwable {
//
//        String baseUrl = GenericFunction.getDataFromExcel(1, 1);
//        String endPoint = GenericFunction.getDataFromExcel(1, 2);
//        String latitude = GenericFunction.getDataFromExcel(1, 3);
//        String longitude = GenericFunction.getDataFromExcel(1, 4);
//        ;
//        String apiKey = GenericFunction.getDataFromExcel(1, 5);
//
//        String url = baseUrl + endPoint + "lat=" + latitude + "&lon=" + longitude + "&key=" + apiKey;
//
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet(url);
//        HttpResponse response = client.execute(request);
//
//        return response;
//    }
//
//    public void validateCurrentAPIResponseStatus(HttpResponse response) {
//
//        int expResponseCode = Integer.parseInt(GenericFunction.getDataFromExcel(1, 6));
//        int actResponseCode = response.getStatusLine().getStatusCode();
//
//        Assert.assertEquals(expResponseCode, actResponseCode);
//    }
//
//    public void validateCurrentAPIResponsData(HttpResponse response) throws Throwable {
//        String jsonResponse = convertResponseIntoString(response);
//        JSONObject jsonObject = new JSONObject(jsonResponse);
//        JSONArray data = jsonObject.getJSONArray("data");
//        String stateCode = data.getJSONObject(0).getString("state_code");
//        System.out.println("Get State Code ::" + stateCode);
//
//    }
//
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
//
//    public HttpResponse executeForcastAPIGetRequest() throws Throwable {
//
//        String baseUrl = GenericFunction.getDataFromExcel(2, 1);
//        String endPoint = GenericFunction.getDataFromExcel(2, 2);
//        String postalCode = GenericFunction.getDataFromExcel(2, 7);
//        String apiKey = GenericFunction.getDataFromExcel(2, 5);
//        String url = baseUrl + endPoint + "postal_code=" + postalCode + "&key=" + apiKey;
//
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet(url);
//        HttpResponse response = client.execute(request);
//
//        return response;
//    }
//
//    public void validateForcastAPIResponsData(HttpResponse response) throws Throwable {
//
//        int expResponseCode = Integer.parseInt(GenericFunction.getDataFromExcel(2, 6));
//        int actResponseCode = response.getStatusLine().getStatusCode();
//
//        if (expResponseCode == actResponseCode) {
//            //TODO API IS NOT ACCEPTING THE KEY
//        } else if (actResponseCode == 403) {
//
//            String jsonResponse = convertResponseIntoString(response);
//            JSONObject jsonObject = new JSONObject(jsonResponse);
//            String jerror = jsonObject.get("error").toString();
//            Assert.fail(jerror);
//
//        }
//
//    }
//
//}
