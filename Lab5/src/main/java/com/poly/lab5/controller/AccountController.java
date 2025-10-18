package com.poly.lab5.controller;

import com.poly.lab5.service.CookieService;
import com.poly.lab5.service.ParamService;
import com.poly.lab5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public String showForm(Model model) {
        // Nếu cookie tồn tại thì tự điền username vào form
        String savedUser = cookieService.getValue("user");
        model.addAttribute("username", savedUser);
        return "account/login";
    }
// ràng buộc
    @PostMapping("/login")
    public String login(Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if (username.equals("poly") && password.equals("123")) {
            sessionService.set("username", username);
            model.addAttribute("message", "Đăng nhập thành công!");

            if (remember) {
                // Cookie hợp lệ, có path = "/", không chứa khoảng trắng
              	cookieService.add("user", username, 24); 
					cookieService.add("pass", password, 24);
            } else {
                	cookieService.remove("user");
					cookieService.remove("pass");    
            }

        } else {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
        }

        model.addAttribute("username", username);
        return "account/login";
    }
    // không 
//    @PostMapping("/login")
//    public String login(Model model) {
//        String username = paramService.getString("username", "");
//        String password = paramService.getString("password", "");
//        boolean remember = paramService.getBoolean("remember", false);
//
//       
//        if (username.isEmpty()) {
//            model.addAttribute("message", "Vui lòng nhập tên đăng nhập!");
//        } else {
//            sessionService.set("username", username);
//            model.addAttribute("message", "Đăng nhập thành công!");
//
//            if (remember) {
//                
//                cookieService.add("user", username, 24);
//                           
//                } else {
//                cookieService.remove("user");
//                
//            }
//        }
//
//        model.addAttribute("username", username);
//        return "account/login";
//    }
}
