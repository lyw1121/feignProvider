package com.example.tw;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="wyl-spring-cloud-consumer")
public interface Invoke {
    @RequestMapping("/listUser")
    String listUser();
}
