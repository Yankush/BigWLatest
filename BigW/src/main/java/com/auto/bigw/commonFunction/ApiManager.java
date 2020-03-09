package com.auto.bigw.commonFunction;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiManager {

    private static RequestSpecification httpRequest;
    private static Response response;

    public static RequestSpecification apiBaseUrl(String baseUrl){

        RestAssured.baseURI = baseUrl;
        httpRequest = RestAssured.given();

        return httpRequest;
    }

    public static void constructHeader(Map<String, String> headerMap){
        //httpRequest.header("content-type","application/json");
        //httpRequest.header("Authorization","Bearer SampleRestAssured");
        //httpRequest.header("Zip-Version","2017-03-01");
        if(headerMap != null) {
            for (String key : headerMap.keySet()) {
                httpRequest.header(key, headerMap.get(key));
            }
        }
    }

    public static void createBody(String jsonBody){
        httpRequest.body(jsonBody);
    }

    public static Response envokeRequest(String method,String endpoint ){

        if(method=="POST") {
             response = httpRequest.request(Method.POST, endpoint);
        }else if(method == "GET"){
             response = httpRequest.request(Method.GET, endpoint);
        }
        return response;
    }

}
