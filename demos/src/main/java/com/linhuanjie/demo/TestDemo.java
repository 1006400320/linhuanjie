package com.linhuanjie.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author: linhuanjie
 * @description:
 * @createTime : 2018-11-29 10:07
 * @email: lhuanjie@qq.com
 */
public class TestDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String url="http://openapi.tuling123.com/openapi/api/v2";
        String question="";
        String apikey="d38891d7ab524688919dce4f3a95abbd";
        String userID="001";//任意值，如果用于微信平台开发，建议使用微信粉丝的userID作为此值
        @SuppressWarnings("resource")
        Scanner scanner=new Scanner(System.in);
        while((question=scanner.nextLine()) != null)
        {
            String data="{\"perception\": {\"inputText\": {\"text\": \""+question+"\"}},\"userInfo\": {\"apiKey\": \""+apikey+"\",\"userId\": \""+userID+"\"}}";

            String response=sendPost(url,data);
            JSONObject jsonObject= JSON.parseObject(response);
            //这里仅仅提取出了文本答案，如果需要其他答案请自行修改代码
            System.out.println(jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("values").getString("text"));
        }
    }

    public static String sendPost(String url,String data){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        System.out.println(result);
        return result;
    }

    
    @Test
    public void test1(){

    } 
}