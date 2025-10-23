package com.lab8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mail {

    @Autowired
    private JavaMailSender mailSender;

    // Địa chỉ email của bạn (người quản trị)
    private final String adminEmail = "cuongndtv00020@fpt.edu.vn";

    public void sendContactMail(String name, String email, String message) {
        // --- 1. Gửi mail cho bạn ---
        SimpleMailMessage adminMail = new SimpleMailMessage();
        adminMail.setTo(adminEmail);
        adminMail.setSubject("Liên hệ mới từ: " + name);
        adminMail.setText(
                "Người gửi: " + name +
                "\nEmail: " + email +
                "\n-----------------------------\n" +
                "Nội dung:\n" + message
        );
        mailSender.send(adminMail);

        // --- 2. Gửi mail xác nhận cho người dùng ---
        SimpleMailMessage userMail = new SimpleMailMessage();
        userMail.setTo(email);
        userMail.setSubject("Xác nhận liên hệ thành công");
        userMail.setText(
                "Xin chào " + name + ",\n\n" +
                "Cảm ơn bạn đã liên hệ với chúng tôi. Dưới đây là nội dung bạn đã gửi:\n\n" +
                message + "\n\n" +
                "Chúng tôi sẽ phản hồi sớm nhất có thể.\n\n" +
                "Trân trọng,\nĐội ngũ hỗ trợ"
        );
        mailSender.send(userMail);
    }
}
