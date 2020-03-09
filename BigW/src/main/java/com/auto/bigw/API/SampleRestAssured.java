package com.auto.bigw.API;

import com.auto.bigw.commonFunction.ApiManager;

import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;

public class SampleRestAssured {

    public static Response response;

    public String zipPayRequestJson(){

        String requestPayload = "{\n" +
                "  \"shopper\": {\n" +
                "    \"title\": \"Mr\",\n" +
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
        return requestPayload;

    }
    public void sendRequest (){

        ApiManager.apiBaseUrl("https://api.sandbox.zipmoney.com.au/merchant/v1");
        Map<String, String> header = new HashMap<String,String>();
        header.put("Content-type", "application/json");
        header.put("Authorization","Bearer test");
        header.put("Zip-Version","2017-03-01");
        ApiManager.constructHeader(header);
        ApiManager.createBody(zipPayRequestJson());
        response = ApiManager.envokeRequest("POST", "/checkouts");

        System.out.println("response data :: " +response.getBody().asString());
        System.out.println("response status :: " +response.statusCode());

    }

    public static void main(String[] args) {
        SampleRestAssured sampleRestAssured = new SampleRestAssured();
        sampleRestAssured.sendRequest();
    }

    public void validateResponse(){

        //TODO
    }
}
