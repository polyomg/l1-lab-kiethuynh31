package com.lab8.controller;

import com.lab8.entity.Account;
import com.lab8.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    @GetMapping("/edit-profile")
    public String editProfile(Model model) {
        Account user = (Account) session.getAttribute("user");
        model.addAttribute("account", user);
        return "account/edit-profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(Account account, Model model) {
        accountService.save(account);
        session.setAttribute("user", account);
        model.addAttribute("account", account);
        model.addAttribute("message", "Cập nhật thành công!");
        return "account/edit-profile";
    }

    @GetMapping("/change-password")
    public String changePasswordForm() {
        return "account/change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String oldpass,
                                 @RequestParam String newpass,
                                 @RequestParam String confirmpass,
                                 Model model) {
        Account user = (Account) session.getAttribute("user");
        if (!user.getPassword().equals(oldpass)) {
            model.addAttribute("message", "Mật khẩu cũ không đúng!");
        } else if (!newpass.equals(confirmpass)) {
            model.addAttribute("message", "Xác nhận mật khẩu không khớp!");
        } else {
            user.setPassword(newpass);
            accountService.save(user);
            model.addAttribute("message", "Đổi mật khẩu thành công!");
        }
        return "account/change-password";
    }
}
