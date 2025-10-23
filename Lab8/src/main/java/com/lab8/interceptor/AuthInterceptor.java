package com.lab8.interceptor;

import com.lab8.entity.Account;
import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        session.setAttribute("securityUri", uri);
        Account user = (Account) session.getAttribute("user");

        // Chưa đăng nhập
        if (user == null) {
            response.sendRedirect("/auth/login");
            return false;
        }

        // Không phải admin mà vào /admin/**
        if (uri.startsWith("/admin") && !user.isAdmin()) {
            response.sendRedirect("/auth/login");
            return false;
        }

        return true;
    }
}
