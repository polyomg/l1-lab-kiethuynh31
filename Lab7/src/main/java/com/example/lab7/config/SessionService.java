package com.example.lab7.config;

import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
    private final HttpSession session;
    public SessionService(HttpSession session) {
        this.session = session;
    }

    public <T> T get(String name, T defaultValue) {
        Object val = session.getAttribute(name);
        return val == null ? defaultValue : (T) val;
    }

    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    public void remove(String name) {
        session.removeAttribute(name);
    }
}

