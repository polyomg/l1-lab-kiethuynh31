package com.poly.lab5.controller;

import com.poly.lab5.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import java.io.File;

@Controller
public class UploadController {
    @Autowired
    ParamService paramService;

    @GetMapping("/upload/form")
    public String form() {
        return "upload/form";
    }

    @PostMapping("/upload/save")
    public String save(@RequestParam("photo") MultipartFile file, Model model) {
        try {
          
            File saved = paramService.save(file, "/uploads/"); 

            String publicUrl = "/uploads/" + saved.getName(); 

            model.addAttribute("message", "Lưu thành công: " + saved.getName());
            // *** Thêm đường dẫn ảnh vào Model ***
            model.addAttribute("imageUrl", publicUrl); 
            
        } catch (Exception e) {
            model.addAttribute("message", "Lỗi lưu file!");
        }
        return "upload/form";
    }
}