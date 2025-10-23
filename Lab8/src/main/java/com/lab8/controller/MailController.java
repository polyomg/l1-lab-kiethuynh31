package com.lab8.controller;

import com.lab8.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {

    @Autowired
    MailService mailService;

    @RequestMapping("/mail/send")
    public String sendMail(Model model) {
        mailService.push("cuongndtv00020@fpt.edu.vn", "Subject", "Body test từ Lab8");
        model.addAttribute("message", "Mail đã được xếp vào hàng đợi!");
        return "mail/sent";
    }
}
