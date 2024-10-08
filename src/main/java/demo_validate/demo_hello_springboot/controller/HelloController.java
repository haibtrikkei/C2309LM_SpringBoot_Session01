package demo_validate.demo_hello_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("name","Nguyễn Hoàng Anh");
        model.addAttribute("address","Hà Nội");
        return "home";
    }
}
