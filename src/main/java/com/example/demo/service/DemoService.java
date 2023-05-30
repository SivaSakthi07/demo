package com.example.demo.service;


import com.example.demo.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class DemoService {


    public String testService(String str1,String str2 ){
        if(str1.equalsIgnoreCase("siv")){
            String nullValue = null;
            nullValue.length();
        }
        return "Merged String is : " + str1 + " " + str2;
    }


    public int length(String str1,String str2 ,String str3){

        return str1.length() + str2.length() + str3.length();
    }

    public HashMap print(Dto dto){


        System.out.println("Input : " + dto.toString());

        HashMap map = new HashMap();
        map.put("Name Key", dto.getName());
        map.put("Age Key",dto.getAge());
        System.out.println("Output Map : " + map );
        return map;
    }
    @Autowired
    private RestTemplate restTemplate;

    public HashMap invokeAPI(){
        // Make a GET request
//        String url = "https://api.example.com/users";
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        System.out.println("GET Response: " + response.getBody());

        // Make a POST request
        String postUrl = "https://dummy.restapiexample.com/api/v1/create";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"name\":\"SS\",\"age\":\"32\",\"salary\":\"120000\"}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<HashMap> postResponse = restTemplate.exchange(postUrl, HttpMethod.POST, requestEntity, HashMap.class);
        System.out.println("POST Response: " + postResponse.getBody());

        return postResponse.getBody();
    }
}
