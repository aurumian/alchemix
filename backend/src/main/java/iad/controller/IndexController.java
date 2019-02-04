package iad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/login")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/craft")
    public String getIndex2(){
        return "index.html";
    }

    @GetMapping("/clan")
    public String getIndex3(){
        return "index.html";
    }

    @GetMapping("/admin/**")
    public String getIndex4(){
        return "forward:/";
    }



}
