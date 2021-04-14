package com.pig4cloud.square.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * <p>
 * 服务提供方接口
 */
@RestController
@RequestMapping
public class DemoController {

    @GetMapping("/req")
    public String req() {
        return "我向你奔赴而来，你就是星辰大海";
    }
}
