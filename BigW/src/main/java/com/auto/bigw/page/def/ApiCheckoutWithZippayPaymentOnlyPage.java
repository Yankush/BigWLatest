package com.auto.bigw.page.def;

import com.auto.bigw.step.def.BaseTest;
import com.auto.bigw.commonFunction.APIGenericFunction;
import com.auto.bigw.commonFunction.ExcelReader;
import com.cucumber.listener.Reporter;
import junit.framework.Assert;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;


public class ApiCheckoutWithZippayPaymentOnlyPage {

    public String testCaseName = BaseTest.testCaseName;


    public String checkoutZipPayPaymentJSON (){



        String REF_TITLE= ExcelReader.getTestDataSheet1(testCaseName, "Title");

        String checkoutZipPayPaymentJSON = "{\n" +
                "  \"shopper\": {\n" +
                "    \"title\": "+"\""+REF_TITLE+"\""+",\n"+
                "    \"first_name\": \"Bigw\",\n" +
                "    \"last_name\": \"Test\",\n" +
                "    \"middle_name\": \"\",\n" +
                "    \"phone\": \"0400000000\",\n" +
                "    \"email\": \"test26@emailaddress.com\",\n" +
                "    \"statistics\": {\n" +
                "      \"currency\": \"AUD\"\n" +
                "    },\n" +
                "    \"billing_address\": {\n" +
                "      \"line1\": \"10 Test st\",\n" +
                "      \"city\": \"Sydney\",\n" +
                "      \"state\": \"NSW\",\n" +
                "      \"postal_code\": \"2000\",\n" +
                "      \"country\": \"AU\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"order\": {\n" +
                "    \"reference\": \"BIGW1\",\n" +
                "    \"amount\": 60,\n" +
                "    \"currency\": \"AUD\",\n" +
                "    \"shipping\": {\n" +
                "      \"pickup\": false,\n" +
                "      \"address\": {\n" +
                "        \"line1\": \"10 Test st\",\n" +
                "        \"city\": \"Sydney\",\n" +
                "        \"state\": \"NSW\",\n" +
                "        \"postal_code\": \"2000\",\n" +
                "        \"country\": \"AU\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"items\": [\n" +
                "      {\n" +
                "        \"name\": \"Pretty shoes\",\n" +
                "        \"amount\": 100,\n" +
                "        \"quantity\": 1,\n" +
                "        \"type\": \"sku\",\n" +
                "        \"reference\": \"12345\",\n" +
                "        \"image_uri\": \"https://pimuat-admin.bigw-online.net/medias/sys_master/images/images/h86/hbf/10855001620510.jpg\"\n" +
                "      },\n" +
                "        {\n" +
                "        \"name\": \"Rewards\",\n" +
                "        \"amount\": -20,\n" +
                "        \"quantity\": 1,\n" +
                "        \"type\": \"discount\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Gift Card\",\n" +
                "        \"amount\": -30,\n" +
                "        \"quantity\": 1,\n" +
                "        \"type\": \"discount\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Shipping carge\",\n" +
                "        \"amount\": 10,\n" +
                "        \"quantity\": 1,\n" +
                "        \"type\": \"shipping\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"config\": {\n" +
                "    \"redirect_uri\": \"https://www.bigw.com.au/\"\n" +
                "  }\n" +
                "}\n" +
                "\n";
        //System.out.println("this is json:: " +checkoutZipPayPaymentJSON);

        return  checkoutZipPayPaymentJSON;
    }




    public HttpResponse sendPostcheckoutZipPayPayment()throws  Exception{

        HttpClient client =  HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://api.sandbox.zipmoney.com.au/merchant/v1/checkouts");
        Reporter.addStepLog("Request Payload :: "+ checkoutZipPayPaymentJSON());
        StringEntity params = new StringEntity(checkoutZipPayPaymentJSON());
        params.setContentType("application/json");
        request.addHeader("content-type", "application/json");
        request.addHeader("Authorization","Bearer SampleRestAssured");
        request.addHeader("Zip-Version","2017-03-01");
        request.setEntity(params);

        Reporter.addStepLog("Header Param :: " +params);
        HttpResponse response = client.execute(request);
        return response;
    }

    public void validateCurrentAPIResponsData(HttpResponse response) throws Throwable {

        APIGenericFunction apiGenericFunction = new APIGenericFunction();
        String stringJsonResponse = apiGenericFunction.convertResponseIntoString(response);
        Reporter.addStepLog("Response Json :: " +stringJsonResponse);
        //String jsonResponse = convertResponseIntoString(response);
        JSONObject jsonObject = new JSONObject(stringJsonResponse);

        String firstName = jsonObject.getJSONObject("shopper").getString("first_name");
        String currency = jsonObject.getJSONObject("shopper").getJSONObject("statistics").getString("currency");

        System.out.println("First Name ::" + firstName);
        Assert.assertEquals("Bigw",firstName);

        System.out.println("Currency type ::" + currency);
        Assert.assertEquals("AUD",currency);

        //SAMPLE
        //JSONArray data = jsonObject.getJSONArray("data");
        //String stateCode = data.getJSONObject(0).getString("state_code");
        //System.out.println("Get State Code ::" + stateCode);

    }
}
