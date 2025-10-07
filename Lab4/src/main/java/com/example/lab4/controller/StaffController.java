package com.example.lab4.controller;

import com.example.lab4.model.Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StaffController {

    @GetMapping("/staff/create/form")
    public String createForm(Model model) {
        model.addAttribute("staff", new Staff()); 
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "demo/staff-validate"; 
    }

    @PostMapping("/staff/create/save")
    public String createSave(
            Model model,
            @RequestPart(name = "photo_file", required = false) MultipartFile photoFile,
            @Valid @ModelAttribute("staff") Staff staff,   
            Errors errors                                 
    ) {
        if (photoFile != null && !photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }

        return "demo/staff-validate";
    }

}
