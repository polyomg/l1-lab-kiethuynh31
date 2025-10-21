package com.example.lab7.controller;

import com.example.lab7.config.SessionService;
import com.example.lab7.dao.ProductDAO;
import com.example.lab7.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO dao;

    @Autowired
    private SessionService session;

    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search";
    }


    // Bài 2: tìm theo từ khóa & phân trang (lưu keywords vào session) - theo đề
    @RequestMapping(value = "/search-and-page", method = {RequestMethod.GET, RequestMethod.POST})
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);

        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        
        Page<Product> page = dao.findByKeywords("%" + kwords + "%", pageable);
        // nếu dùng DSL thay bằng:
        // Page<Product> page = dao.findAllByNameLike("%" + kwords + "%", pageable);

        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page";
    }
}
