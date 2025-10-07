package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dthcn")
public class RectangleController {

    @Autowired
    HttpServletRequest request;

    
    @GetMapping("/form")
    public String form() {
        return "rectangle";
    }

    
    @PostMapping("/calc")
    public String calc(Model model) {
        double cd = Double.parseDouble(request.getParameter("length")); // khai báo trên form 
        double cr = Double.parseDouble(request.getParameter("width"));

        double area = cd * cr;
        double perimeter = 2 * (cd + cr);

        model.addAttribute("area", area);// tên biến hiển thị bên view dt
        model.addAttribute("perimeter", perimeter);

        return "rectangle";
    }
}
