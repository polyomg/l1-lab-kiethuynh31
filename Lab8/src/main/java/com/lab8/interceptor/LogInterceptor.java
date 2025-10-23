package com.lab8.interceptor;

import com.lab8.entity.Account;
import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Date;

@Component
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Account user = (Account) request.getSession().getAttribute("user");
        String fullname = (user != null) ? user.getFullname() : "Guest";
        System.out.println("[LOG] " + request.getRequestURI() + " | " + new Date() + " | User: " + fullname);
        return true;
    }
}
