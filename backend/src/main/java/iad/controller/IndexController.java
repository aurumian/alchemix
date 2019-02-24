package iad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/login")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/admin/**")
    public String getIndex0(){
        return "forward:/";
    }

    @GetMapping("/craft")
    public String getIndex3(){
        return "forward:/";
    }

    @GetMapping("/clan")
    public String getIndex4(){
        return "forward:/";
    }

    @GetMapping("/inventory")
    public String getIndex5(){
        return "forward:/";
    }

}
