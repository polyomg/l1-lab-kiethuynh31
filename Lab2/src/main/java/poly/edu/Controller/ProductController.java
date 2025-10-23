package poly.edu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.entity.Product;



@Controller
@RequestMapping("/product")
public class ProductController {

    // GET form
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("p", new Product());
        return "bai3form";
    }

    // POST save
    @PostMapping("/save")
    public String save(@ModelAttribute("p") Product p, Model model) {
        model.addAttribute("p", p);
        return "bai3form";
    }
}