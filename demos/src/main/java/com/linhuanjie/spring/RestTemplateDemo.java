package com.linhuanjie.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Springboot — 用更优雅的方式发HTTP请求(RestTemplate详解)
 * https://www.cnblogs.com/javazhiyin/p/9851775.html
 */
public class RestTemplateDemo {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("ly.mama.cn/main/index", String.class);
        System.out.println("forObject = " + forObject);

        ResponseEntity<String> forEntity = restTemplate.getForEntity("ly.mama.cn/main/index", String.class);
        System.out.println("forEntity = " + forEntity);

    }

}
