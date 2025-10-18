package com.poly.lab5.controller;

import com.poly.lab5.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @Autowired
    ParamService paramService;
    @Autowired
    CookieService cookieService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        sessionService.set("user", "PolyUser");

        // KHÔNG DÙNG khoảng trắng trong cookie value
        // cookieService.add("msg", "Cookie Created", 1);

        // Dùng ký tự gạch dưới hoặc encode
        cookieService.add("msg", "Cookie_Created_OK", 1);

        return "Session user: " + sessionService.get("user") + " | Cookie set OK";
    }
}
