package poly.edu.Controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.entity.Product;
@Controller
public class Bai4ProductController {
    private List<Product> items = new ArrayList<>();
    @GetMapping("/bai4/form")
    public String form(Model model) {
       
        model.addAttribute("p", new Product());
        // sp hiện tại
        model.addAttribute("current", null);
        // danh sách sản phẩm
        model.addAttribute("items", items);
        model.addAttribute("current", new Product("iPhone 30", 5000.0));
        return "bai4form";
    }

    @PostMapping("/bai4/save")
    public String save(@ModelAttribute("p") Product p, Model model) {
        items.add(p);
        // current: để hiển thị ở ô số 2
        model.addAttribute("current", p);
        // reset form
        model.addAttribute("p", new Product());
        model.addAttribute("items", items);
        return "bai4form";
    }
    public Bai4ProductController() {
        items.add(new Product("SL", 1.0));
        items.add(new Product("B", 12.0));
    }
}
