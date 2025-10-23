package com.example.lab6.controller;

import com.example.lab6.dao.CategoryDAO;
import com.example.lab6.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDAO dao;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("item", new Category());
        model.addAttribute("items", dao.findAll());
        return "category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        model.addAttribute("item", dao.findById(id).orElse(new Category()));
        model.addAttribute("items", dao.findAll());
        return "category/index";
    }

    @PostMapping("/create")
    public String create(Category item) {
        dao.save(item);
        return "redirect:/category/index";
    }

    @PostMapping("/update")
    public String update(Category item) {
        dao.save(item);
        return "redirect:/category/edit/" + item.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dao.deleteById(id);
        return "redirect:/category/index";
    }
}
