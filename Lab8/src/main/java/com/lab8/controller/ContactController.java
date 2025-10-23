package com.lab8.controller;

import com.lab8.service.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private Mail mail;

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            Model model) {

        try {
            mail.sendContactMail(name, email, message);
            model.addAttribute("success", "Gửi liên hệ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Gửi mail thất bại! Kiểm tra cấu hình SMTP.");
        }
        return "contact";
    }
}
