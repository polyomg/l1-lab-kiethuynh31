package poly.edu.Controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.entity.Product;

@Controller
public class Bai4ProductController {

    @GetMapping("/bai4/form")
    public String form(Model model) {
        Product p = new Product("iPhone 30", 5000.0);
        model.addAttribute("p", p);
        model.addAttribute("items", getItems());
        return "bai4form";
    }

    @PostMapping("/bai4/save")
    public String save(@ModelAttribute("p") Product p, Model model) {
        model.addAttribute("p", p);
        model.addAttribute("items", getItems());
        return "bai4form";
    }

    public List<Product> getItems() {
        return Arrays.asList(
            new Product("A", 1.0),
            new Product("B", 12.0)
        );
    }
}

