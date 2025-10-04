package poly.edu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai1")
public class OkController {

    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("method", "m2()");
        return "b1ok";
    }

    @PostMapping("/ok")
    public String m1(@RequestParam(required = false) String x, Model model) {
        if (x != null) {
            model.addAttribute("method", "m3()");
        } else {
            model.addAttribute("method", "m1()");
        }
        return "b1ok";
    }
}
